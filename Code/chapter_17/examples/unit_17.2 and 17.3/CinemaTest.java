import java.util.function.*;
import java.time.*;
import java.time.temporal.*;

public class CinemaTest {
    public static void main(String args[]) {
        UnaryOperator<MovieSchedule> delayByOneHour= p-> {
            LocalTime time = p.getTime();
            time = time.plus(1, ChronoUnit.HOURS);
            p.setTime(time);
            return p;
        } ;
        UnaryOperator<MovieSchedule> delayByOneDay= p-> {
            p.setDate(p.getDate().plus(1, ChronoUnit.DAYS));
            return p;
        } ;
        
        Movie shining = new Movie("Shining", "Thriller", 5);
        MovieSchedule shiningSchedule = new MovieSchedule(shining, LocalDate.of(2014, 5, 29), LocalTime.of(21,0));
        UnaryOperator<MovieSchedule> delayByOneHourAndOneDay = Cinema.composeChanges(delayByOneHour, delayByOneDay);
        System.out.println(Cinema.changeSchedule(shiningSchedule, delayByOneHourAndOneDay));
        
    }
}