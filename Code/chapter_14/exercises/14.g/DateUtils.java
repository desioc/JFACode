import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static long getInterval(LocalDateTime ldt1, LocalDateTime ldt2, ChronoUnit chronoUnit) {
        return chronoUnit.between(ldt1, ldt2);
    }
} 