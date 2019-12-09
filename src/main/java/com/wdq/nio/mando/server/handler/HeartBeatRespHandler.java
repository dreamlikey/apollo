package com.wdq.nio.mando.server.handler;

import com.wdq.nio.mando.codec.Header;
import com.wdq.nio.mando.codec.MandoMessage;
import com.wdq.nio.mando.codec.MandoMessageDecoder;
import com.wdq.nio.mando.codec.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 心跳检测<br/>
 * 一定时间周期内没有收到客户端心跳消息
 * 释放资源,
 * 清除客户端登录信息,
 * 等待客户端重连
 * @author wudq
 * @date 2019/11/20
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(MandoMessageDecoder.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Header header = ((MandoMessage) msg).getHeader();
        if (header.getType() == MessageType.HEARTBEAT_REQ.type) {
            log.info("heart beat message : "+((MandoMessage) msg).getHeader().toString());
            MandoMessage message = buildHeartBeatMessage();
            ctx.writeAndFlush(message);
        } else {
            //消息交个通道后面的hadler进行处理
            ctx.fireChannelRead(msg);
        }
    }

    /**
     * 心跳消息
     * @return
     */
    private MandoMessage buildHeartBeatMessage() {
        MandoMessage message = new MandoMessage();
        Header header = new Header();
        header.setType(MessageType.HEARTBEAT_RESP.type);
        message.setHeader(header);
        return message;
    }
}

