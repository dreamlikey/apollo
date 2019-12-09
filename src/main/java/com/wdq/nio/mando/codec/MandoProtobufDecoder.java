package com.wdq.nio.mando.codec;

import com.google.protobuf.MessageLite;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * @author wudq
 * @date 2019/12/6
 */
public class MandoProtobufDecoder extends ProtobufDecoder {
    public MandoProtobufDecoder(MessageLite prototype) {
        super(prototype);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        super.decode(ctx, msg, out);
    }
}
