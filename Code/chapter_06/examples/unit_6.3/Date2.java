public class Date2 {
    private int day;
    private int month;
    private int year;
    public void setDay(int d) {
        if (d > 0 && d <= 31) {
            day = d;
        }
        else {
            System.out.println("Invalid day");
        }
    }
    public int getDay() {
        return day;
    }
    public void setMonth(int m) {
        if (m > 0 && m <= 12) {
            month = m;
        }
        else {
            System.out.println("Invalid month");
        }
    }
    public int getMonth() {
        return month;
    }
    public void setYear(int y) {
        year = y;
    }
    public int getYear() {
        return year;
    }
}