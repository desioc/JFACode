public class Employee {
    private int number;
    private int hireYear;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public int getHireYear() {
        return hireYear;
    }

    public int getYearDifference(Employee other) {
        return (hireYear - other.hireYear);
    }


}