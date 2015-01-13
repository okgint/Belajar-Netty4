package org.ogin.nettyku;

import org.ogin.nettyku.connector.Connector;

/**
 * Created by Jabrik on 25/11/2014.
 */
public interface Server {
    DiscardProvider getDiscardProvider();

    public void setConnector(Connector connector);
    public Connector getConnector();
}
