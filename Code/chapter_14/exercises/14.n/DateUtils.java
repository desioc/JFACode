import java.time.Instant;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static long getInterval(Instant instant1, Instant instant2, 
      ChronoUnit chronoUnit) {
        return chronoUnit.between(instant1, instant2);
    }
    
    public static long getPastTime(Instant instant1, ChronoUnit chronoUnit) {
        return getInterval(instant1, Instant.now(), chronoUnit);
    }

    public static String getExactTime() {
        LocalTime now = LocalTime.now();
        String exactTime = (now.getHour() + ":" + now.getMinute() + " " 
            + now.getSecond());
        return exactTime; 
    }

    public static String formatDate(LocalDateTime localDateTime, String pattern)  
            throws DateTimeException {
        String formattedDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            formattedDate = formatter.format(localDateTime);
        } catch (DateTimeException dateTimeException) {
            dateTimeException.printStackTrace();
            throw dateTimeException;
        }
        return formattedDate;
    }

    public static LocalDate parseDate(String date, String pattern) 
      throws DateTimeParseException {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException dateTimeParseException) {
            dateTimeParseException.printStackTrace();
            throw dateTimeParseException;
        }
        return localDate;
    }

} 