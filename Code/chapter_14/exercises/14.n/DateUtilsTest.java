import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtilsTest {

    private static final String DATE_FORMAT = "MM/dd/yy  hh:mm a";

    public static void main(String args[]) {
        final String exactTime = DateUtils.getExactTime();
        System.out.println("Time right now: " + exactTime);
        Instant twoThousand = Instant.parse("2000-01-01T00:00:00.00Z");
        Instant twoThousandAndTen = Instant.parse("2010-01-01T00:00:00.00Z");
        long daysInterval = DateUtils.getInterval(
          twoThousand, twoThousandAndTen, ChronoUnit.DAYS);
        System.out.println("From 1st January 2000 to 1st January 2010 "
          + daysInterval + " days are passed");
        final long minutesPassed = 
          DateUtils.getPastTime(twoThousand, ChronoUnit.MINUTES);
        System.out.println(minutesPassed + " minutes " +
          "have passed since January 1st 2010 ");
        LocalDateTime localDateTime = LocalDateTime.now();
        final String formattedDate = 
          DateUtils.formatDate(localDateTime, DATE_FORMAT);
        System.out.println("Formatted date: " + formattedDate);
        LocalDate localDate = 
          DateUtils.parseDate(formattedDate, DATE_FORMAT);
        System.out.println(localDate);
        System.out.println("Let's throw an exception!");
        localDate = DateUtils.parseDate(formattedDate, "ABC");
    }
}