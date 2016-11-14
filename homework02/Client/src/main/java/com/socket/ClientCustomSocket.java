package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientCustomSocket {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String msgFromServer;

        try (Socket clientSocket = new Socket("localhost", 9999);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream())) {

            while (!"stop".equals(msgFromServer = reader.readLine())) {
                System.out.println("Server: " + msgFromServer);
                String clientMsg = scanner.nextLine();
                writer.println(clientMsg);
                writer.flush();
            }
            System.out.println("Good buy!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
