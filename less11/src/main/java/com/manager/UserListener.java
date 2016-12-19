package com.manager;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class UserListener implements AsyncListener {
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("noComplete:");
        System.out.println(event.toString());
    }

    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("onTimeout:");
        System.out.println(event.toString());
    }

    public void onError(AsyncEvent event) throws IOException {
        System.out.println("onError:");
        System.out.println(event.toString());
    }

    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("onStartAsync:");
        System.out.println(event.toString());
    }
}
