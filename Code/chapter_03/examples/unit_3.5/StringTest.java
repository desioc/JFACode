public class StringTest {
    public static void main(String args[]) {
        String name = new String("Salvatore Quasimodo");
        name ="Salvatore Quasimodo";
        String a ="claudio";
        String b = a.toUpperCase();
        System.out.println(a); // a does not change
        System.out.println(b); // b is uppercase
    }
}