package con_prod_2;

import java.util.concurrent.BlockingQueue;

public class Client extends Thread {
    private BlockingQueue<Integer> bucket;

    public Client(BlockingQueue bucket) {
        this.bucket = bucket;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int number = bucket.take();
                System.out.println("client: " + number);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
