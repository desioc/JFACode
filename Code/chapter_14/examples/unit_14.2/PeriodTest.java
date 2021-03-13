import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class PeriodTest {
    public static void main(String args[]) {
        LocalDate myBirthday = LocalDate.of(1974,1,26);
        LocalDate today = LocalDate.now();
        Period period = Period.between(myBirthday, today);
        System.out.printf("You lived %s years, %s months and %s days until now", period.getYears(), period.getMonths(), period.getDays());
    }
}