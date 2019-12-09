package com.wdq.nio.mando.client.handler;

import com.wdq.nio.mando.codec.Header;
import com.wdq.nio.mando.codec.MandoMessage;
import com.wdq.nio.mando.codec.MandoMessageDecoder;
import com.wdq.nio.mando.codec.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 心跳检测<br/>
 * 一定时间内没有收到服务端心跳消息，重连
 * @author wudq
 * @date 2019/11/20
 */
public class HeartBeatReqHandler extends ChannelHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(MandoMessageDecoder.class);

    private volatile ScheduledFuture<?> heartBeat;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        heartBeat = ctx.executor().scheduleAtFixedRate(
            new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 30,
            TimeUnit.SECONDS);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (heartBeat != null) {
            heartBeat.cancel(Boolean.TRUE);
            heartBeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }

    /**
     * 心跳任务
     */
    private class HeartBeatTask implements Runnable{

        private final ChannelHandlerContext ctx;

        public HeartBeatTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            MandoMessage message = buildHeartBeatMessage();
            ctx.writeAndFlush(message);
            log.info("send heart beat req ："+message.getHeader().toString());
        }

        /**
         * 心跳消息
         * @return
         */
        private MandoMessage buildHeartBeatMessage() {
            MandoMessage message = new MandoMessage();
            Header header = new Header();
            header.setType(MessageType.HEARTBEAT_REQ.type);
            header.setLength(123);
            header.setSessionId(99999L);
            message.setHeader(header);
            return message;
        }
    }

}

