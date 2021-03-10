package model;

public class Client implements Comparable{

    private int id;
    private int arrivalTime;
    private int serviceTime;
    private int finishingTime = 0;
    private int waitingTime;

    public Client(int id) {
        this.id = id;
        this.arrivalTime = (int)( Math.random() * (InputData.getMaxArrTime() - InputData.getMinArrTime()) + InputData.getMinArrTime());
        this.serviceTime = (int)( Math.random() * (InputData.getMaxServiceTime() - InputData.getMinServiceTime()) + InputData.getMinServiceTime());
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
        this.waitingTime = finishingTime - arrivalTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public String toString() {
        return "(" + getId() + ", " + getArrivalTime() + ", " + getServiceTime() + ") ";
    }

    public int compareTo(Object o) {
        Client other = (Client) o;
        return this.arrivalTime - other.arrivalTime;
    }
}
