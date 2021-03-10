package model;

import fileio.MyFileWriter;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue implements Runnable{

    private MyFileWriter fw;
    private ArrayBlockingQueue<Client> clients;
    private Thread thread;
    private int queueID;
    private int waitingTime;
    private boolean running = false;
    private int currentTime;

    public Queue(MyFileWriter fw, int id, int clientNo) {
        this.fw = fw;
        this.queueID = id;
        clients = new ArrayBlockingQueue<>(clientNo);
    }

    public int getNoOfClients() {
        return clients.size();
    }

    public ArrayBlockingQueue<Client> getClients() {
        return clients;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void start() throws IOException {
        if (!running) {
            fw.write("Starting Queue " + queueID);
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() throws IOException {
        if (running) {
            fw.write("Shutting down queue " + queueID);
            running = false;
        }
    }

    public void addClient(Client client) throws IOException {
        clients.add(client);
        currentTime = client.getArrivalTime();
        waitingTime += client.getWaitingTime();
        start();
        fw.write("Queue " + queueID + ": (" + client.getId() + ", " + client.getArrivalTime() + ", " + client.getServiceTime() + ")");
    }

    public void serveClient(Client client) throws InterruptedException {
        fw.write("Client " + client.getId() + "started on queue " + queueID + ", process time = " + client.getServiceTime() + " s");

        for (int i = 0; i < client.getServiceTime(); i++) {
            Thread.sleep(100);
            waitingTime--;
            currentTime++;
        }

        fw.write("Client " + client.getId() + " served in queue " + queueID);
        client.setFinishingTime(currentTime);
    }

    @Override
    public void run() {
        while (running) {
            if (clients.isEmpty()) {
                try {
                    stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    //remove client from front of queue and process
                    serveClient(clients.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
