public class CloneableClassTest {
    public static void main(String args[]) throws CloneNotSupportedException {
        CloneableClass cloneableClass = new CloneableClass();
        cloneableClass.setField("TEST");
        System.out.println(cloneableClass);
        System.out.println(cloneableClass.clone());
    }
}