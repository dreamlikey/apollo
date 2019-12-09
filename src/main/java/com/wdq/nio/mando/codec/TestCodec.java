package com.wdq.nio.mando.codec;

import com.google.protobuf.InvalidProtocolBufferException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author wudq
 * @date 2019/11/25 
 * @Description: TODO
 */
public class TestCodec {

    public MandoMessage getMessage() {
        MandoMessage nettyMessage = new MandoMessage();
        Header header = new Header();
        header.setLength(123);
        header.setSessionId(99999L);
        header.setType((byte) 1);
        nettyMessage.setHeader(header);
        nettyMessage.setBody("abcdefg-----------------------AAAAAA");
        return nettyMessage;
    }

    public ByteBuf encode(MandoMessage msg) throws Exception {
        ByteBuf sendBuf = Unpooled.buffer();
        sendBuf.writeInt(msg.getHeader().getCrcCode());
        sendBuf.writeInt(msg.getHeader().getLength());
        sendBuf.writeLong(msg.getHeader().getSessionId());
        sendBuf.writeByte(msg.getHeader().getType());
        sendBuf.writeInt(0);
        sendBuf.setInt(4, sendBuf.readableBytes() - 8);
        return sendBuf;
    }

    public MandoMessage decode(ByteBuf in) throws Exception {
        MandoMessage message = new MandoMessage();
        Header header = new Header();
        header.setCrcCode(in.readInt());
        header.setLength(in.readInt());
        header.setSessionId(in.readLong());
        header.setType(in.readByte());
        message.setHeader(header);
        return message;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestCodec testC = new TestCodec();
        MandoMessage message = testC.getMessage();
        System.out.println(message + "[body ] " );

        for (int i = 0; i < 5; i++) {
            ByteBuf buf = testC.encode(message);
            MandoMessage decodeMsg = testC.decode(buf);
            System.out.println(decodeMsg.getHeader().toString() + "[body ] " );
            System.out
                .println("-------------------------------------------------");

        }

//        RpcReqProto.RpcReq rpcReq = createProto();
//        System.out.println(decode(encode(rpcReq)));

    }

    public static RpcReqProto.RpcReq createProto() {
        RpcReqProto.RpcReq.Builder builder = RpcReqProto.RpcReq.newBuilder();
        RpcReqProto.RpcReq rpcReq = builder.setRpcReqId("100").setMethodName("com.wdq.nio.mando.codec.save").setReqTime("201992332").build();
        return rpcReq;
    }

    public static byte[] encode(RpcReqProto.RpcReq rpcReq) {
        byte[] bytes = rpcReq.toByteArray();
        return bytes;
    }

    public static RpcReqProto.RpcReq decode(byte[] bytes) throws InvalidProtocolBufferException {
        return RpcReqProto.RpcReq.parseFrom(bytes);
    }
}
