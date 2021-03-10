package model;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Laura - Beatrix Nagy
 * DateParser - this class contains a method for parsing a date in String form
 */
public class DateParser {

    public static LocalDateTime parse(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date;
    }
}
