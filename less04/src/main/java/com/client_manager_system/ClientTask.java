package com.client_manager_system;

public class ClientTask implements Runnable{

    private Client client;

    public ClientTask(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void run() {
        System.out.println("client:: " + client);
    }
}
