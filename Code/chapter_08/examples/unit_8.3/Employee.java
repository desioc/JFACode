public class Employee {
    private String name;
    private int salary;
    private int number;
    private String birthDate;
    private String hireDate;

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}