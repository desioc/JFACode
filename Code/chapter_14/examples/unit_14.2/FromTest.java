import java.time.*;
import java.time.format.*;
import java.util.*;

public class FromTest {
    public static void main(String args[]) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        YearMonth ym = YearMonth.from(localDate);
        System.out.println(ym);
    }
}