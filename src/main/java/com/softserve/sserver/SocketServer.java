/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.sserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author Nubaseg
 */
public class SocketServer implements Runnable {

    private static int DEFAULT_PORT = 3224;
    private static String DEFAULT_IP = "127.0.0.1";
    private InetAddress ipAddress;
    private int port;
    private ServerSocket mServerSocket;
    private ArrayList<SocketThread> sockets;
    private Thread mthread;

    public SocketServer(InetAddress ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        sockets = new ArrayList<SocketThread>();
        mthread = new Thread(this);
        mthread.start();

    }

    public void run() {
        try {
            mServerSocket = new ServerSocket(port, 0, ipAddress);
            while (true) {
                Socket nSocket = mServerSocket.accept();
                sockets.add(new SocketThread(nSocket));
            }
        } catch (IOException e) {
        } finally {
            try {
                mServerSocket.close();
            } catch (IOException e) {
            }
        }

    }
}
