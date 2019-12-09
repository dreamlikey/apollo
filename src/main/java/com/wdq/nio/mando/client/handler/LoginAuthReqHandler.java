package com.wdq.nio.mando.client.handler;

import com.wdq.nio.mando.codec.Header;
import com.wdq.nio.mando.codec.MandoMessage;
import com.wdq.nio.mando.codec.MessageType;
import com.wdq.nio.mando.server.handler.LoginAuthRespHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 握手接入和安全认证
 * @author wudq
 * @date 2019/11/20
 */
public class LoginAuthReqHandler extends ChannelHandlerAdapter {
    private static final Logger log = LoggerFactory.getLogger(LoginAuthReqHandler.class);
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(buildLoginReq());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MandoMessage mandoMessage = (MandoMessage) msg;
        Header header = mandoMessage.getHeader();
        log.info("server msg: "+((MandoMessage) msg).getHeader().toString());
        if (header.getType() == MessageType.LOGIN_RESP.type) {
            Byte loginResult = (Byte) mandoMessage.getBody();
//            if (1 != loginResult) {
//               ctx.close();
//            } else {
//                log.info("login is ok : "+mandoMessage);
//                ctx.fireChannelRead(msg);
//            }
            ctx.fireChannelRead(msg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private MandoMessage buildLoginReq() {
        MandoMessage message = new MandoMessage();
        Header header = new Header();
        header.setType(MessageType.LOGIN_REQ.type);
        header.setLength(123);
        header.setSessionId(99999L);
        message.setHeader(header);
        return message;
    }
}
