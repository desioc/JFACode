abstract class AbstractClass {
    public static final int VALUE = 1;
}
interface Interface {
    int VALUE = 2;
}
class Subclass extends AbstractClass implements Interface {
    public static void main(String args[]) {
        System.out.println(VALUE);
    }
}
