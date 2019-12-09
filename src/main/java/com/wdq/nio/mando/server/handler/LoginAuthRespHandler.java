package com.wdq.nio.mando.server.handler;

import com.wdq.nio.mando.codec.Header;
import com.wdq.nio.mando.codec.MandoMessage;
import com.wdq.nio.mando.codec.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 握手接入和安全认证
 * @author wudq
 * @date 2019/11/20
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(LoginAuthRespHandler.class);

    /**
     * 客户端ip白名单
     */
    private String[] whiteClients = {"127.0.0.1"};

    private Map<String, Boolean> connectedNode = new ConcurrentHashMap<>();

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        connectedNode.remove(ctx.channel().remoteAddress().toString());
        ctx.close();
        ctx.fireExceptionCaught(cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("client msg: "+((MandoMessage) msg).getHeader().toString());
        Header header = ((MandoMessage) msg).getHeader();
        if (header.getType() == MessageType.LOGIN_REQ.type) {
            int result = 0;
            String address = ctx.channel().remoteAddress().toString();
            log.error("client login address : {}", address);
            //白名单检查
            for (String client : whiteClients) {
                if (address.contains(client)) {
                    result = 1;
                } else {
                    throw new RuntimeException("illegal client login");
                }
            }
            //重复登录检查
            if (result == 1 && connectedNode.get(address) == null) {
                connectedNode.put(address,Boolean.TRUE);
            } else {
                log.error("client duplicate login : ", address);
                result = 0;
            }

            ctx.writeAndFlush(buildLoginAuth(result));
        } else if (header.getType() == MessageType.HEARTBEAT_REQ.type) {
            ctx.fireChannelRead(msg);
        }
    }

    /**
     * 心跳消息
     * @return
     */
    private MandoMessage buildLoginAuth(int result) {
        MandoMessage message = new MandoMessage();
        Header header = new Header();
        header.setType(MessageType.LOGIN_RESP.type);
        header.setLength(123);
        header.setSessionId(99999L);
        message.setHeader(header);
        message.setBody(result);
        return message;
    }
}
