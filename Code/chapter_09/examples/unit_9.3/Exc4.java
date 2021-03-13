public class Exc4 {
    public static void main(String args[]) {
        int a = 10;
        int b = 0;
        try {
            int c = a/b;
            System.out.println(c);
        } catch (ArithmeticException exc) {
            System.out.println("Division by zero...");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            System.out.println("Operation attempt");
        }
    }
}