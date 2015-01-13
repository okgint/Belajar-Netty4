package org.ogin.nettyku.connector;

import org.ogin.nettyku.Server;

import java.net.InetSocketAddress;

/**
 * Created by Jabrik on 25/11/2014.
 */
public interface Connector {
    InetSocketAddress getBindAddrss();
    void start();
    void stop();

    void setServer(Server server);
}
