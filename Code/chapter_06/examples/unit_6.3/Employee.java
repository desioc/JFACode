public class Employee {
    private String name;
    private int years; //we are thinking age in terms of years
//    . . .
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int n) {
        years = n;
    }
    public int getYearsDifference(Employee other) {
        return (getYears() - other.years);
    }
}