package org.ogin.nettyku;

import org.ogin.nettyku.connector.Connector;
import org.ogin.nettyku.protocol.discard.DiscardProvider;

/**
 * Created by Jabrik on 25/11/2014.
 */
public class ServerImpl implements Server {
    private boolean running;
    private Connector connector;

    @Override
    public void setConnector(Connector connector) {
    this.connector  = connector;
    }

    @Override
    public Connector getConnector() {
        return connector;
    }

    public void start() {
        if(running)
            return;
        connector.start();
        connector.setServer(this);
        running = true;
    }
}
