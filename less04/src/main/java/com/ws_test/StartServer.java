package com.ws_test;

import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import java.util.Scanner;

public class StartServer {

    public static void main(String[] args) throws DeploymentException {

        Server server = new Server("localhost", 9090, "/ws", CustomServerSocket.class);

        server.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        server.stop();
    }

}
