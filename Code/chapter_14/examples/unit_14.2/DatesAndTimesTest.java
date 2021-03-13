import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class DatesAndTimesTest {
    public static void main(String args[]) {
        System.out.println("Now: "+ LocalTime.now());
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime);
    }
}