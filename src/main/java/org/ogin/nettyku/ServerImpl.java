package org.ogin.nettyku;

import com.google.common.util.concurrent.AbstractIdleService;
import org.ogin.nettyku.connector.Connector;

/**
 * Created by Jabrik on 25/11/2014.
 */
public class ServerImpl extends AbstractIdleService implements Server {
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

    @Override
    protected void startUp() throws Exception {
        if(running)
            return;
        connector.start();
        connector.setServer(this);
        running = true;
    }

    @Override
    protected void shutDown() throws Exception {

    }
}
