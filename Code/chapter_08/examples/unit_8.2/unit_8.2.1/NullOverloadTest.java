public class NullOverloadTest {
    public void overloadedMethod(Object object) {
        System.out.println("overloadedMethod(Object object)");
    }

    public void overloadedMethod(String string) {
        System.out.println("overloadedMethod(String string)");
    }

 /* public void overloadedMethod(Integer integer) {
        System.out.println("overloadedMethod(Integer integer)");
    } */

    public static void main(String args[]) {
        var nullOverloadTest = new NullOverloadTest();
        nullOverloadTest.overloadedMethod(null);
    }
}