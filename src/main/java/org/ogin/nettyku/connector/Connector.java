package org.ogin.nettyku.connector;

import org.ogin.nettyku.Server;

import java.net.InetSocketAddress;

/**
 * Created by Jabrik on 25/11/2014.
 */
public interface Connector extends Lifecycle{
    InetSocketAddress getBindAddrss();

    void setServer(Server server);
}
