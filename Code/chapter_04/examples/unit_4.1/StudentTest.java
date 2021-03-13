public class StudentTest {
    public static void main(String args[]) {
        Student student1 = new Student("Simone");
        Student student2 = new Student("Simone");
        System.out.println(student1 == student2);
    }
}