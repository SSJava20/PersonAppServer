/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softserve.sserver;

import com.softserve.persondao.HibernateUtil;
import com.softserve.persondao.PersonDAO;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Nubaseg
 */
public class SocketThread implements Runnable {

    private Thread mthread;
    private Socket clientSocket;
    private CommandProcessor processor;

    public SocketThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        processor = new CommandProcessor(this);
        processor.setPersonDAO(new PersonDAO(HibernateUtil.configureSessionFactory()));
        mthread = new Thread(this);
        mthread.start();
    }

    public void sendCommand(String commandString) {
        PrintWriter out;
        System.out.println(commandString);
        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    clientSocket.getOutputStream())), true);
            out.println(commandString);
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        Scanner in = null;
        try {
            in = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e1) {
        }
        while (true) {
            String getStringCommand = "";
            try {
                getStringCommand = in.nextLine();
                System.out.println(getStringCommand);
                processor.operateCommand(getStringCommand);
            } catch (Exception e) {
                try {
                    clientSocket.close();
                } catch (IOException e1) {
                }
                break;
            }
            System.out.println(getStringCommand);
        }
        Thread.currentThread().interrupt();
    }
}
