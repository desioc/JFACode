import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class ZonesTest {
    public static void main(String args[]) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String id : zoneIds) {
            System.out.println(id);
        }
        LocalDateTime ldt = LocalDateTime.now();
        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdt = ldt.atZone(losAngeles);
        ZoneOffset offset =  zdt.getOffset();
        System.out.println(offset);
        Clock clock = Clock.system(ZoneId.of("Asia/Tokyo"));
        //System.out.println("Tokyo instant "+clock.instant());
        System.out.println("Tokyo local date "+LocalDate.now(clock));
    }
}