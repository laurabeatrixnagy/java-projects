package model;

import fileio.MyFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Queue> queues;
    private int maxClientNumber;

    public List<Queue> getQueues() {
        return queues;
    }

    public int getMaxClientNumber() {
        return maxClientNumber;
    }

    public Service(int queueNumber, int clientNumber, MyFileWriter fw) {
        this.queues = new ArrayList<>();
        this.maxClientNumber = clientNumber;

        //generate queues with unique id-s
        for (int i = 1; i <= queueNumber; i++) {
            this.queues.add(new Queue(fw, i, maxClientNumber ));
        }
    }

    public Queue selectQueue() {

        int minWaitingTime = Integer.MAX_VALUE;
        Queue queue = null;

        for (Queue q : this.getQueues()) {
            //find queue with min waiting time
            if (q.getWaitingTime() <= minWaitingTime) {
                queue = q;
                minWaitingTime = q.getWaitingTime();
            }
        }

        return queue;
    }

    public void select(Client c) throws IOException {
            this.selectQueue().addClient(c);
    }
}
