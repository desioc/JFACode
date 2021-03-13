public class ArithmeticVarArgsTest {
    public static void main(String... args) {
        var obj = new ArithmeticVarArgs();
        System.out.println(obj.sum(1,2,3));
        System.out.println(obj.sum());
        System.out.println(obj.sum(1,2));
        System.out.println(obj.sum(1,2,3,5,6,8,2,43,4));
    }
}