package fileio;

import model.MonitoredData;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Laura - Beatrix Nagy
 * FileOutput - this class contains methods for writing the results of executing the tasks
 * to the corresponding files.
 */
public class FileOutput {

    public static void writeTask1(List<MonitoredData> activities) throws IOException {
        File myFile = new File("Task_1.txt");

        FileWriter fw = new FileWriter(myFile);

        int i = (int) activities.stream().count();
        fw.append("Number of items in activity list = " + i + "\n\n");
        activities.forEach(x -> {
            try {
                fw.append(x.toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fw.close();
    }

    public static void writeTask2(int days) throws IOException {
        File myFile = new File("Task_2.txt");

        FileWriter fw = new FileWriter(myFile);

        fw.append("Number of  distinct days that appear in the monitoring data = " + days);
        fw.close();
    }

    public static void writeTask3(Map<String, Integer> map) throws IOException {
        File myFile = new File("Task_3.txt");

        FileWriter fw = new FileWriter(myFile);
        for (Map.Entry<String, Integer> entry : map.entrySet())
            fw.append("Activity = " + entry.getKey() +
                    ", Frequency = " + entry.getValue() + "\n");
        fw.close();
    }

    public static void writeTask4(Map<Integer, Map<String, Long>> map) throws IOException {
        File myFile = new File("Task_4.txt");

        FileWriter fw = new FileWriter(myFile);

       for (Integer day : map.keySet()) {
            fw.append("Day of the month: " + day.toString() + " \n" );
            for (Map.Entry<String, Long> entry : map.get(day).entrySet())
                fw.append("Activity = " + entry.getKey() +
                        ", Frequency = " + entry.getValue() + "\n");
           fw.append("\n" );
        }

        fw.close();
    }

    public static void writeTask5(Map<String,  Long> map) throws IOException {
        File myFile = new File("Task_5.txt");

        FileWriter fw = new FileWriter(myFile);

        for (String key : map.keySet()) {
            long seconds = map.get(key);
            long hours = TimeUnit.SECONDS.toHours(seconds);
            seconds -= TimeUnit.HOURS.toSeconds(hours);
            long minutes = TimeUnit.SECONDS.toMinutes(seconds);
            seconds -= TimeUnit.MINUTES.toSeconds(minutes);
            StringBuilder sb = new StringBuilder(64);
            sb.append(hours);
            sb.append(" Hours:");
            sb.append(minutes);
            sb.append(" Minutes:");
            sb.append(seconds);
            sb.append(" Seconds");
            fw.append(key + ":       " + sb + "\n");
        }
        fw.close();
    }

    public static void writeTask6(List<String> list) throws IOException {
        File myFile = new File("Task_6.txt");

        FileWriter fw = new FileWriter(myFile);
        fw.append("Activities that have more than 90% of the records with duration < 5 minutes:\n\n");

        for (String s : list) {
            fw.append(s + "\n");
        }

        fw.close();
    }
}
