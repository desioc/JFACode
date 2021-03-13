public class Programmer extends Employee {
    private String[] certifications;

    public Programmer(int number, int hireYear) {
        setNumber(number);
        setHireYear(hireYear);
    }
    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }

    public String[] getCertifications() {
        return certifications;
    }
}