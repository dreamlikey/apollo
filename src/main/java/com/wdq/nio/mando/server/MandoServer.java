package com.wdq.nio.mando.server;

import com.wdq.nio.mando.codec.MandoConstant;
import com.wdq.nio.mando.codec.MandoMessageDecoder;
import com.wdq.nio.mando.codec.MandoMessageEncoder;
import com.wdq.nio.mando.codec.RpcReqProto;
import com.wdq.nio.mando.server.handler.HeartBeatRespHandler;
import com.wdq.nio.mando.server.handler.LoginAuthRespHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * @author wudq
 * @date 2019/11/21 002110
 * @Description: TODO
 */
public class MandoServer {
    private static final Logger log = LoggerFactory.getLogger(MandoServer.class);

    public void start(int port) throws Exception {
        //客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //网路读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //server启动辅助
            ServerBootstrap bs = new ServerBootstrap();
            bs.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                //TCP参数
                .option(ChannelOption.SO_KEEPALIVE,Boolean.TRUE )
                .childHandler(new ServerChannelInitializer());

            ChannelFuture cf = bs.bind(MandoConstant.REMOTEIP,MandoConstant.PORT).sync();
            log.info("Mando server start ok : "
                + (MandoConstant.REMOTEIP + " : " + MandoConstant.PORT));

            //阻塞等待服务端链路关闭
            cf.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 2020;
        new MandoServer().start(port);
    }
}

/**
 * 绑定I/O事件
 * @author wudq
 * @date 2019/11/21
 */
class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //manda解码解码器
        ch.pipeline() .addLast(new MandoMessageDecoder(1024, 4, 4));
        //manda编码器
        ch.pipeline().addLast("MessageEncoder", new MandoMessageEncoder());
        //握手接入和安全验证
        ch.pipeline().addLast("LoginAuthHandler", new LoginAuthRespHandler());
        //心跳检测
        ch.pipeline().addLast("HeartBeatHandler", new HeartBeatRespHandler());
        //RpcReqProto解码
        ch.pipeline().addLast(new ProtobufDecoder(RpcReqProto.RpcReq.getDefaultInstance()));
        //encoded
        ch.pipeline().addLast(new LengthFieldPrepender(4));
        //RpcReqProto编码
        ch.pipeline().addLast(new ProtobufEncoder());
    }
}

