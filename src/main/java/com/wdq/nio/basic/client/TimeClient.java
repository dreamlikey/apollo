package com.wdq.nio.basic.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wudq
 * @date 2019/11/19
 * @Description:
 */
public class TimeClient {
    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //客户端的启动辅助类
            Bootstrap bs = new Bootstrap();
            bs.group(group)
                .channel(NioSocketChannel.class)
                //绑定网络IO事件
                .handler(new TimeClientChannelHandler())
                //TCP参数
                .option(ChannelOption.TCP_NODELAY, true);
            ChannelFuture cf =  bs.connect(host,port).sync();
            cf.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 2020;
        new TimeClient().connect(port, "127.0.0.1");
    }

 }

 class TimeClientChannelHandler extends ChannelInitializer<SocketChannel> {

     @Override
     protected void initChannel(SocketChannel socketChannel) throws Exception {
//         socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder());
         socketChannel.pipeline().addLast(new TimeClientHandler());
     }
 }

 class TimeClientHandler extends ChannelHandlerAdapter {

    @Override
     public void channelActive(ChannelHandlerContext ctx) throws Exception {
         byte[] req = "time client codec".getBytes();
         for (int i = 1; i<=100; i++) {
             System.out.println("循环发送了："+i);
             ByteBuf message = Unpooled.buffer(req.length);
             message.writeBytes(req);
             ctx.writeAndFlush(message);
         }
     }

     @Override
     public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
         ByteBuf buf = (ByteBuf) msg;
         byte[] rep = new byte[buf.readableBytes()];
         buf.readBytes(rep);
         String body = new String(rep, "UTF-8");
         System.out.println("Time client receive body : " + body);
     }

     @Override
     public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         ctx.close();
     }
 }
