package con_prod_2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClientServerTest {

    public static void main(String[] args) {

        BlockingQueue bucket = new ArrayBlockingQueue(10);
        Client client = new Client(bucket);
        Server server = new Server(bucket);

        client.start();
        server.start();

    }

}
