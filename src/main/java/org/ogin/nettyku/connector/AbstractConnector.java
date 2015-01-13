package org.ogin.nettyku.connector;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.ogin.nettyku.Server;

import java.net.InetSocketAddress;


/**
 * Created by Jabrik on 25/11/2014.
 */
public abstract class AbstractConnector implements Connector {
    private boolean running;
    private InetSocketAddress bindAddres;
    private ServerBootstrap bootstrap;
    private ChannelFuture channel;
    private Server server;
    private ServerBootstrap bootstrap1;

    public AbstractConnector(InetSocketAddress bindAddres) {
        this.bindAddres = bindAddres;
    }

    @Override
    public InetSocketAddress getBindAddrss() {
        return this.bindAddres;
    }

    protected abstract ChannelInitializer getInitializer();

    @Override
    public void start() {
        if (this.running) {
            return;
        }
        this.bootstrap = createServerBootstrap();
        this.channel = bootstrap.bind(getBindAddrss());
    }

    protected ServerBootstrap createServerBootstrap() {
        bootstrap1 = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        bootstrap1.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 124)
                .childHandler(getInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        return bootstrap1;
    }

    @Override
    public void stop() {
        if(!this.running)
            return;
        try {
            channel.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setServer(Server server) {
        this.server = server;
    }
}
