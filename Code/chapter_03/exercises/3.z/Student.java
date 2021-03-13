public class Student {
    public String name;
    public String surname;
    public String schoolClass;

    public Student(String nam, String sur, String sc) {
        name = nam;
        surname = sur;
        schoolClass = sc;
    }

    public String toString() {
        return "Student: "+ name +" "+ surname +"\nClass "+ schoolClass;
    }
}