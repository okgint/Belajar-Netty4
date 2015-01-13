package org.ogin.nettyku;

import org.ogin.nettyku.connector.Connector;

/**
 * Created by Jabrik on 25/11/2014.
 */
public class ServerImpl implements Server {
    private boolean running;
    private Connector connector;
    private DiscardProvider provider;

    public void setDiscardProvider(DiscardProvider provider) {
        this.provider = provider;
    }
    @Override
    public DiscardProvider getDiscardProvider() {
        return provider;
    }

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
