import java.util.*;
import java.text.*;

public class ImmutableObjectsTest {
    public static void main(String args[]) {
        String name = "Simone";
        String nameCapitolized = name.toUpperCase();
        System.out.println(name);
        System.out.println(nameCapitolized);
        Calendar calendar = Calendar.getInstance();
        ImmutableObject o = new ImmutableObject(1, "test", calendar);
        o.printCalendar();
        calendar.set(06,10,2001);
        o.printCalendar();
    }
}