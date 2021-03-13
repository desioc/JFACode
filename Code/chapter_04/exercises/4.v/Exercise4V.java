public class Exercise4V {

    public static void main(String args[]) {
        StrangeCalc strangeCalc = new StrangeCalc();
        System.out.println("42.7 + 47.8 = " + strangeCalc.sum(42.7, 47.8));
        System.out.println("42.7 x 47.8 x 2= " + strangeCalc.multiply(42.7, 47.8, 2));
        System.out.println("The maximum between 42.7, 47.8, 50, 2, 8, 89 is " + strangeCalc.maximum(42.7, 47.8, 50, 2, 8, 89));
        System.out.println("The minimum between 42.7, 47.8, 50, 2, 8, 89 is " + strangeCalc.minimum(42.7, 47.8, 50, 2, 8, 89));
    }
}