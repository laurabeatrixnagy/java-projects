package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Laura - Beatrix Nagy
 * MonitoredData - this class represents az activity recorder by the system.
 */

public class MonitoredData {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String activityLabel;

    public MonitoredData(String startTime, String endTime, String activity){
        this.startTime = DateParser.parse(startTime);
        this.endTime = DateParser.parse(endTime);
        if (activity.charAt(activity.length() - 1) == '\t')
            this.activityLabel = activity.substring(0, activity.length() - 1);
        else this.activityLabel = activity;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return LocalDate.from(startTime);
    }

    /**
     * @return the activityLabel
     */
    public String getActivityLabel() {
        return activityLabel;
    }

    /**
     * @return the duration between startTime and endTime
     */
    public long getDuration() {
        return Duration.between(startTime, endTime).getSeconds();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "<" + this.activityLabel + ", " + formatter.format(startTime) + ", " + formatter.format(endTime) + ">";
    }

}
