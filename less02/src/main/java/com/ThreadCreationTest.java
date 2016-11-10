package com;

import java.util.concurrent.*;

public class ThreadCreationTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new CustomThread("My custom name").start();
        new Thread(new CustomRunnable()).start();

        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> submit = service.submit(new CustomCallable());
        String s = submit.get();
        service.shutdown();
        System.out.println("msg from thread = " + s);
    }

}

class CustomCallable implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        return "hello from callable thread type";
    }
}

class CustomRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class CustomThread extends Thread {
    public CustomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}