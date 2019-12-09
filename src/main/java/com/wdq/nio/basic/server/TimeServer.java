package com.wdq.nio.basic.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * The type Time server.
 * @author wudq
 * @date 2019 /11/19
 * @Description: TODO
 */
public class TimeServer {

    /**
     * Bind.
     * @param port the port
     * @throws Exception the exception
     */
    public void bind(int port) throws Exception{
        //NIO线程组，接收客户端连接
        EventLoopGroup bossGroup   = new NioEventLoopGroup();
        //NIO线程组，进行SocketChannel网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //启动服务端的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                //声明channel为NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                //设置TCP参数
                .option(ChannelOption.SO_KEEPALIVE, true)
                //绑定网络I/O事件
                .childHandler(new ChildChannelHandler());
            //绑定监听端口，sync同步阻塞等待绑定完成
            ChannelFuture cf = b.bind(port).sync();
            //阻塞等待服务端链路关闭
            cf.channel().closeFuture().sync();
        } finally {
            //优雅退出，释放线程池资源（服务器链路关闭之后执行）
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 2020;
        try {
            new TimeServer().bind(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * The type Child channel handler.
 */
class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) {
        socketChannel.pipeline().addLast(new TimeServerHandler());
    }

}

/**
 * The type Time server handler.
 */
class TimeServerHandler extends ChannelHandlerAdapter {

    public static int count = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取数据
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Time server receive order : "+ body + ";The counter id : "+ ++count);
//
//        //发送数据
//        byte[] resp = "time server codec".getBytes();
//        ByteBuf codec = Unpooled.buffer(req.length);
//        codec.writeBytes(resp);
//        ctx.writeAndFlush(codec);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常释放ChannelHandlerContext资源
        ctx.close();
    }
}