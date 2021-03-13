import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class TemporalQueriesTest {
    public static void main(String args[]) {
        TemporalQuery<?> query = TemporalQueries.precision();
        
        LocalDate now  = LocalDate.now();
        printPrecision(now);
        printPrecision(LocalTime.now());
        
        boolean isWeekend = now.query(new IsWeekendQuery());
        System.out.println(isWeekend);
    }

    public static void printPrecision(Temporal temporal) {
        TemporalQuery<?> query = TemporalQueries.precision();
        System.out.println(temporal.query(query));
    }

    static class  IsWeekendQuery implements TemporalQuery<Boolean> {
        public Boolean queryFrom(TemporalAccessor input) {
            LocalDate data = LocalDate.from(input);
            DayOfWeek dayOfWeek = data.getDayOfWeek();
            return (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY));
        }
    }
}