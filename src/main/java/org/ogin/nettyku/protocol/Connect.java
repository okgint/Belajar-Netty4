package org.ogin.nettyku.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

import java.net.SocketAddress;

/**
 * Created by Jabrik on 25/11/2014.
 */
public class Connect extends ChannelOutboundHandlerAdapter {
    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.out.println("Connected");
        ctx.channel().write("Welcome to My Discard Server");
        ctx.flush();
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("Write");
        ReferenceCountUtil.release(msg);
        promise.setSuccess();
    }
}
