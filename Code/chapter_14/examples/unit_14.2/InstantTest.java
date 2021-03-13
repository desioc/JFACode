import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class InstantTest {
    public static void main(String args[]) {
        Instant inTenMinutes = Instant.now().plus(10, ChronoUnit.MINUTES);
        System.out.println(inTenMinutes);
        Instant now = Instant.now();
        boolean b = now.isAfter(Instant.EPOCH);
        System.out.println(b);
        Duration  d = Duration.between(Instant.EPOCH, Instant.now());
        System.out.println(d);
        Instant birth = Instant.parse("2004-04-14T07:00:00.00Z");
        long daysFromBirth = birth.until(Instant.now(), ChronoUnit.DAYS);
        System.out.println("daysFromBirth:"+ daysFromBirth);
        Duration duration = Duration.between(birth, Instant.now());
        System.out.println(duration.toDays());
    }
}