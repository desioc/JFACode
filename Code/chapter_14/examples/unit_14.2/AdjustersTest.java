import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class AdjustersTest {
    public static void main(String args[]) {
        LocalDate today = LocalDate.now();
        System.out.printf("Next sunday : %s\n",today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
        System.out.printf("Post the next blog article on %s",today.with(new NextBlogPostAdjuster()));
    }

    static class NextBlogPostAdjuster implements TemporalAdjuster {
        public  Temporal adjustInto(Temporal input) {
            LocalDate date = LocalDate.from(input);
            LocalDate result = date.plusDays(4);
            DayOfWeek dayOfWeek = result.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                result = result.plusDays(1);
            }
            return result;
        }
    }
}