import java.time.Month;

public class SeasonSwitchExpressionEnumTest {
    public static void main(String args[]) {
        Month month = Month.APRIL;
        //int yield = 0; this is valid
        if (args.length!=0) {
            month = Month.of(Integer.parseInt(args[0]));
        }
         /* String season = switch(month) {
            case DECEMBER, JANUARY, FEBRUARY ->"winter";
            case MARCH, APRIL, MAY ->"spring";
            case JUNE, JULY, AUGUST ->"summer";
            case SEPTEMBER, OCTOBER, NOVEMBER ->"autumn";
            //default  -> "not identifiable"; //the default clause is optional
        } ; */
        //SYNTAX WITH  YIELD
    /* String season = switch(month) {
            case DECEMBER, JANUARY, FEBRUARY: yield "winter";
            case MARCH, APRIL, MAY: yield "spring";
            case JUNE, JULY, AUGUST: yield "summer";
            case SEPTEMBER, OCTOBER, NOVEMBER: yield "autumn";
        }; */
        //FALLTHROUGH SYNTAX
    /* String season = switch(month) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY: yield "winter";
            case MARCH, APRIL, MAY: yield "spring";
            case JUNE, JULY, AUGUST: yield "summer";
            case SEPTEMBER, OCTOBER, NOVEMBER: yield "autumn";
        }; */
        //MIXED INVALID SYNTAX
    /* String season = switch(month) {
            case DECEMBER, JANUARY, FEBRUARY: yield "winter";
            case MARCH, APRIL, MAY: yield "spring";
            case JUNE, JULY, AUGUST: yield "summer";
            case SEPTEMBER, OCTOBER, NOVEMBER ->"autumn";
        }; */
        //MIXED VALID SYNTAX
     /* String season = switch(month) {
            case DECEMBER, JANUARY, FEBRUARY -> {yield "winter";}
            case MARCH, APRIL, MAY -> {yield "spring";}
            case JUNE, JULY, AUGUST -> {yield "summer";}
            case SEPTEMBER, OCTOBER, NOVEMBER -> {yield "autumn";}
        }; */
        
        String season = switch(month) {
            case DECEMBER, JANUARY, FEBRUARY -> {yield  /*break*/ "winter";}
            case MARCH, APRIL, MAY -> {yield  /*break*/"spring2";}
            case JUNE, JULY, AUGUST -> "summer";
            case SEPTEMBER, OCTOBER, NOVEMBER ->  "autumn";
        }; 
        
//        System.out.println("The season is "+ season);
        //
        print(switch(month) {
            case DECEMBER, JANUARY, FEBRUARY ->"winter";
            case MARCH, APRIL, MAY ->"spring";
            case JUNE, JULY, AUGUST ->"summer";
            case SEPTEMBER, OCTOBER, NOVEMBER ->"autumn";
            //default  -> "not identifiable"; //the default clause is optional
        } );
    }

    public static void print(String season) {
        System.out.println("The season is "+ season);
    }
}