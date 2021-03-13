public class Exc3 {
    public static void main(String args[]) {
        int a = 10;
        int b = 0;
        try {
            int c = a/b;
            System.out.println(c);
        } catch (ArithmeticException exc) {
            System.out.println("Division by zero...");
        } catch (NullPointerException exc) {
            System.out.println("Null reference...");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}