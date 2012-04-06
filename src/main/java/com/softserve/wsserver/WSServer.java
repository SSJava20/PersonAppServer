/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.wsserver;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

/**
 *
 * @author Nubaseg
 */
public class WSServer extends Server implements Runnable {

    WebSocket websocket;
    SelectChannelConnector connector;
    WebSocketHandler wsHandler;
    ResourceHandler rsHandler;
    ArrayList<WSThread> wsClients;
    private Thread mthread;

    public WSServer(int port) {
        connector = new SelectChannelConnector();
        connector.setPort(port);
        this.addConnector(connector);
        wsHandler = new MyWebSocketHandler();
        this.setHandler(wsHandler);
        rsHandler = new ResourceHandler();
        rsHandler.setDirectoriesListed(true);
        rsHandler.setResourceBase("src/webapp");
        wsHandler.setHandler(rsHandler);
        wsClients = new ArrayList<WSThread>();
        mthread = new Thread(this);
        mthread.start();
    }

    public ArrayList<WSThread> getWSClients() {
        return wsClients;
    }

    @Override
    public void run() {
        try {
            start();
            join();
        } catch (Exception e) {
        }
    }
}

class MyWebSocketHandler extends WebSocketHandler {

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
        return new WSThread((WSServer) this.getServer());
    }
}
