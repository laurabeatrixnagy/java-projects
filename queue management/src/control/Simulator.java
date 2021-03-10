package control;

import fileio.MyFileWriter;
import model.Client;
import model.InputData;
import model.Queue;
import model.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulator implements Runnable{

    List<Client> clients;
    private Thread thread;
    private MyFileWriter fw;
    private Service service;

    public Simulator(MyFileWriter fw) {
        clients = new ArrayList<>();
        this.fw = fw;
        service = new Service(InputData.getQueueNo(), InputData.getClientNo(), fw);

        //generate clients with random arrival and service times
        for (int i = 1; i <= InputData.getClientNo(); i++) {
            clients.add(new Client(i));
        }

        //sort clients based on arrival time
        Collections.sort(clients);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        //keep track of number of clients served
        int clientNo = 0;

        for (int i = 0; i < InputData.getSimulationInterval(); i++) {
            fw.write("\nTime: " + i + " s");
            fw.write("Waiting clients: ");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //stop simulation when all clients have been served
            if (clientNo >= clients.size()) continue;

            for (int k = 0; k < clients.size(); k++) {
                if (clients.get(k).getFinishingTime() == 0) {
                        fw.write(clients.get(k).toString());

                }
            }

            for (int k = 0; k < service.getQueues().size(); k++) {
                fw.write("Queue " + (k+1) + ":");
            }

            while (clientNo < clients.size() && clients.get(clientNo).getArrivalTime() == i) {
                try {
                    service.select(clients.get(clientNo++));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        fw.write("\nSimulation over");

        for (Queue q : service.getQueues()) {
            try {
                q.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //compute average waiting time by summing the waiting times of each client,
        //then dividing the result by the number of clients
        float totalWaitingTime = 0;
        for (Client c : clients) {
            totalWaitingTime += c.getWaitingTime();
        }

        float averageWaitingTime = totalWaitingTime/InputData.getClientNo();
        fw.write("Average waiting time : " + averageWaitingTime);
        fw.close();

        System.out.println("Simulation finished!!!");
    }
}
