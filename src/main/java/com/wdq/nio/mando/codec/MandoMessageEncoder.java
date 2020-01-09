package com.wdq.nio.mando.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * mando消息编码器
 * @author wudq
 * @date 2019/11/20
 */
public class MandoMessageEncoder extends MessageToByteEncoder<MandoMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MandoMessage msg, ByteBuf sendBuf) throws Exception {
        //crcCode
        sendBuf.writeInt(msg.getHeader().getCrcCode());
        //消息总长度，包含header 和 body
        sendBuf.writeInt(msg.getHeader().getLength());
        sendBuf.writeLong(msg.getHeader().getSessionId());
        sendBuf.writeByte(msg.getHeader().getType());
        sendBuf.writeInt(0);
        sendBuf.setInt(4, sendBuf.readableBytes() - 8);
//        RpcReqProto.RpcReq rpcReq = (RpcReqProto.RpcReq) msg.getBody();
//
//        sendBuf.writeBytes(rpcReq.toByteArray());

    }

}
