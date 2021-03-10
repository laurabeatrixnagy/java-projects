package model;

public class InputData {

    private static int clientNo;
    private static int queueNo;
    private static int simulationInterval;
    private static int minArrTime, maxArrTime;
    private static int minServiceTime, maxServiceTime;

    public static int getClientNo() {
        return clientNo;
    }
    public static void setClientNo(int clientNo) {
        InputData.clientNo = clientNo;
    }
    public static int getQueueNo() {
        return queueNo;
    }
    public static void setQueueNo(int queueNo) {
        InputData.queueNo = queueNo;
    }
    public static int getSimulationInterval() {
        return simulationInterval;
    }
    public static void setSimulationInterval(int simulationInterval) {
        InputData.simulationInterval = simulationInterval;
    }
    public static int getMinArrTime() {
        return minArrTime;
    }
    public static void setMinArrTime(int minArrTime) {
        InputData.minArrTime = minArrTime;
    }
    public static int getMaxArrTime() {
        return maxArrTime;
    }
    public static void setMaxArrTime(int maxArrTime) {
        InputData.maxArrTime = maxArrTime;
    }
    public static int getMinServiceTime() {
        return minServiceTime;
    }
    public static void setMinServiceTime(int minServiceTime) {
        InputData.minServiceTime = minServiceTime;
    }
    public static int getMaxServiceTime() {
        return maxServiceTime;
    }
    public static void setMaxServiceTime(int maxServiceTime) {
        InputData.maxServiceTime = maxServiceTime;
    }

}
