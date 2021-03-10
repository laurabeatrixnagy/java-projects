package control;

import fileio.FileOutput;
import model.MonitoredData;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * @author Laura - Beatrix Nagy
 * Controller - this class contains the driving methods for the application.
 */
public class Controller {

    private ArrayList<MonitoredData> activityList;
    private Stream<String> stream = Files.lines(Paths.get("Activities.txt"));

    public Controller() throws IOException {
        this.activityList = new ArrayList<>();
    }

    public void executeTask1() throws IOException {

        this.activityList = (ArrayList<MonitoredData>) stream.map(s -> s.split("\t\t"))
                .map(x -> new MonitoredData(x[0], x[1], x[2]))
                .collect(Collectors.toList());

        FileOutput.writeTask1(activityList);
    }

    public void executeTask2() throws IOException {

        int nrOfDays = (int) activityList.stream().map(x -> x.getStartDate())
                                                    .distinct()
                                                    .count();
        FileOutput.writeTask2(nrOfDays);
    }

    public void executeTask3() throws IOException {

        Map<String, Integer> activityFrequencyMap = new HashMap<>();
        activityList.forEach(s -> activityFrequencyMap.merge(s.getActivityLabel(), 1, Math::addExact));

        FileOutput.writeTask3(activityFrequencyMap);

    }

    public void executeTask4() throws IOException {

        Map<Integer, Map<String, Long>> dailyFrequencyMap = activityList.stream()
                                                                        .collect(Collectors.groupingBy(x -> x.getStartDate().getDayOfMonth(),
                                                                                Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting())));
        FileOutput.writeTask4(dailyFrequencyMap);

    }

    public void executeTask5() throws IOException {

        Map<String, Long> totalDurationMap = activityList.stream()
                                                        .collect(Collectors.groupingBy(x -> x.getActivityLabel(),
                                                                Collectors.reducing(0L, x -> x.getDuration(), (a, b) -> a + b)));
        FileOutput.writeTask5(totalDurationMap);
    }

    public void executeTask6() throws IOException {

        Map<String, Long> fiveMinActivityFrequencies = activityList.stream()
                                                                    .filter(t -> t.getDuration() <= 5 * 60)
                                                                    .collect(Collectors.groupingBy(t -> t.getActivityLabel(),
                                                                     Collectors.counting()));

        Map<String, Integer> activityFrequencyMap = new HashMap<>();
        activityList.forEach(s -> activityFrequencyMap.merge(s.getActivityLabel(), 1, Math::addExact));


        List<String> filteredList= activityList.stream()
                                                .map(x -> x.getActivityLabel())
                                                .filter(s -> fiveMinActivityFrequencies.containsKey(s))
                                                .filter(s -> fiveMinActivityFrequencies.get(s) >= 0.9 * activityFrequencyMap.get(s))
                                                .distinct()
                                                .collect(toList());

        FileOutput.writeTask6(filteredList);
    }

}
