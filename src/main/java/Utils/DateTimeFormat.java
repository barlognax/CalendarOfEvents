package Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormat {

    public static LocalDate dateFormat(String dateString) {
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, dtfDate);
        return date;
    }
    public static LocalTime timeFormat(String timeString) {
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeString, dtfTime);
        return time;
    }

}
