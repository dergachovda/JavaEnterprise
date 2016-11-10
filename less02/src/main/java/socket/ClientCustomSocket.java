package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientCustomSocket {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 9999);

        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());

        String msgFromServer;

        while (!"stop".equals(msgFromServer = reader.readLine())) {
            System.out.println("msg from server = " + msgFromServer);
            String clientMsg = scanner.nextLine();
            writer.println(clientMsg);
            writer.flush();
        }
    }

}
