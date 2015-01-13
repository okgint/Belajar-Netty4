package org.ogin.nettyku;

import org.ogin.nettyku.connector.Connector;

/**
 * Created by Jabrik on 25/11/2014.
 */
public interface Server {
    public void setConnector(Connector connector);
    public Connector getConnector();
}
