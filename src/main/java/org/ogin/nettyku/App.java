package org.ogin.nettyku;

import org.ogin.nettyku.connector.Connector;
import org.ogin.nettyku.connector.InsecureConnector;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Connector connector = new InsecureConnector();
        ServerImpl server = new ServerImpl();
        server.setConnector(connector);
        server.startUp();
    }
}
