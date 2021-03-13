import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class DatesTest {
    public static void main(String args[]) {
        YearMonth yearMonth = YearMonth.now();
        YearMonth leapFebruary = YearMonth.of(2012, Month.FEBRUARY);
        System.out.println("This year lasts: "+ yearMonth.lengthOfYear() +" days");
        System.out.println("The month of February in the year 2012 lasted "+ leapFebruary.lengthOfMonth() +" days "+ yearMonth.getMonth());
        LocalDate date = LocalDate.of(2004, Month.NOVEMBER, 12);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
        MonthDay md = MonthDay.of(Month.JULY, 29);
        LocalDate ld = md.atYear(2012);
        System.out.println(ld);
        Year year = Year.of(2014);
        System.out.println(year);
    }
}