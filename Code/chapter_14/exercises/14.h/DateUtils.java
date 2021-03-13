import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static long getInterval(Instant instant1, Instant instant2, 
      ChronoUnit chronoUnit) {
        return chronoUnit.between(instant1, instant2);
    }
    
    public static long getPastTime(Instant instant1, ChronoUnit chronoUnit) {
        return getInterval(instant1, Instant.now(), chronoUnit);
    }
} 