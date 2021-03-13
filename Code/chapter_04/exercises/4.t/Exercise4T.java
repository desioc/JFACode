public class Exercise4T {

    public static void main(String args[]) {
        SimpleCalc simpleCalc = new SimpleCalc();
        System.out.println("42.7 + 47.8 = " + simpleCalc.sum(42.7, 47.8));
        System.out.println("42.7 - 47.8 = " + simpleCalc.subtract(42.7, 47.8));
        System.out.println("42.7 x 47.8 = " + simpleCalc.multiply(42.7, 47.8));
        System.out.println("42.7 : 47.8 = " + simpleCalc.divide(42.7, 47.8));
        System.out.println("the rest of the division between 42.7 and 47.8 è " + simpleCalc.returnRest(42.7, 47.8));
        System.out.println("the maximum between 42.7 and 47.8 è " + simpleCalc.maximum(42.7, 47.8));
        System.out.println("the minimum between 42.7 and 47.8 è " + simpleCalc.minimum(42.7, 47.8));
    }

}