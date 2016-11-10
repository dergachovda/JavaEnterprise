package com.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is running...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ServerCustomSocket(clientSocket).start();
        }
    }
}
