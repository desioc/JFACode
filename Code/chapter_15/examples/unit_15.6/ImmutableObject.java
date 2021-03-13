import java.util.*;

public class ImmutableObject {
    private final int integer; // primitive instance variable 
    private final String string; // immutable complex instance variable 
    private final Calendar calendar; // complex instance variable 
    // Costructor that set its instance variable with parameters
    public ImmutableObject (int integer, String string, Calendar calendar) {
        this.integer = integer;
        this.string = string;
        // Follows point 3
        this.calendar = (Calendar)calendar.clone();
    }
    //This method follows the point 4
    public Calendar getDate(){
        return (Calendar)calendar.clone();
    }
    //Test method
    public void printCalendar(){
        System.out.println(calendar);
    }
}