package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerCustomSocket extends Thread {

    private Socket clientSocket;

    public ServerCustomSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

            String msgFromClient;
            System.out.println("Client@" + Thread.currentThread().getName() + " connect.");
            writer.println("Hello!");
            writer.flush();

            while (!"stop".equals(msgFromClient = reader.readLine())) {
                System.out.println("Client@" + Thread.currentThread().getName() + ": " + msgFromClient);
                String serverMsg = msgFromClient.toUpperCase();
                writer.println(serverMsg);
                writer.flush();
            }

            writer.println("stop");
            writer.flush();

            System.out.println("Client@" + Thread.currentThread().getName() + " disconnect.");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
