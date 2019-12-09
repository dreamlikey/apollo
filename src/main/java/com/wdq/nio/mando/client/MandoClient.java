package com.wdq.nio.mando.client;

import com.wdq.nio.mando.client.handler.HeartBeatReqHandler;
import com.wdq.nio.mando.client.handler.LoginAuthReqHandler;
import com.wdq.nio.mando.codec.MandoConstant;
import com.wdq.nio.mando.codec.MandoMessageDecoder;
import com.wdq.nio.mando.codec.MandoMessageEncoder;
import com.wdq.nio.mando.codec.RpcReqProto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * 客户端
 * @author wudq
 * @date 2019/11/21
 * @Description: TODO
 */
public class MandoClient {
    private static final Logger log = LoggerFactory.getLogger(MandoClient.class);

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void connect(String host, int port) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bs = new Bootstrap();
            bs.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,Boolean.TRUE )
                .handler(new ClientChannelInitializer());

            ChannelFuture cf = bs.connect(
                new InetSocketAddress(host, port),
                new InetSocketAddress(MandoConstant.LOCALIP,
                    MandoConstant.LOCAL_PORT)).sync();

            cf.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
            //断线重连
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        connect(host, port);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new MandoClient().connect("127.0.0.1", port);
    }
}

class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //manda解码解码器
        ch.pipeline() .addLast(new MandoMessageDecoder(1024, 4, 4));
        //manda编码器
        ch.pipeline().addLast("MessageEncoder",new MandoMessageEncoder());
//        //RpcReqProto解码
//        ch.pipeline().addLast(new ProtobufDecoder(RpcReqProto.RpcReq.getDefaultInstance()));
//        //encoded
//        ch.pipeline().addLast(new LengthFieldPrepender(4));
//        //RpcReqProto编码
//        ch.pipeline().addLast(new ProtobufEncoder());

        //握手接入和安全验证
        ch.pipeline().addLast(new LoginAuthReqHandler());
        //心跳检测
        ch.pipeline().addLast("HeartBeatHandler", new HeartBeatReqHandler());
    }
}
