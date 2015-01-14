package org.ogin.nettyku.connector;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import org.ogin.nettyku.protocol.discard.DiscardInitializer;

import java.net.InetSocketAddress;

/**
 * Created by Jabrik on 25/11/2014.
 */
public class InsecureConnector extends AbstractConnector {
    ChannelHandler handler;
    public InsecureConnector() {
        this(new InetSocketAddress(5000));
    }

    public InsecureConnector(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }

    @Override
    protected ChannelInitializer getInitializer() {
        return new DiscardInitializer();
    }
}
