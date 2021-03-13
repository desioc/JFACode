public class StaticIntializerTest {
    public static void main(String args[]) throws Throwable {
        try {
            new StaticIntializerExample();
        }
        catch (Throwable exc) {
            System.out.println("Cannot initialize class: " + exc.getCause());
        }
    }
}
class StaticIntializerExample {
    static int a /* = getValue(10) */;
    static {
        a = getValue(10);
    }

    static int getValue(int a) {
        if (a == 10) {
            throw new IllegalArgumentException("The argument "+ a +" is not valid");
        }
        return 10;
    }
}