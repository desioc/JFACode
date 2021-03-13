public class WeekUtils {
    public static String getTypeOfWeekDay(String dayOfWeek) {
        String typeOfWeekDay;
        switch (dayOfWeek) {
            case"Monday":
                typeOfWeekDay ="Start week";
            break;
            case"Tuesday":
            case"Wednesday":
            case"Thursday":
                typeOfWeekDay ="Mid week";
            break;
            case"Friday":
                typeOfWeekDay ="End work week";
            break;
            case"Saturday":
            case"Sunday":
                typeOfWeekDay ="Weekend";
            break;
            default:
                typeOfWeekDay ="Indefinite!";
            break;
        }
        return typeOfWeekDay;
    }
}