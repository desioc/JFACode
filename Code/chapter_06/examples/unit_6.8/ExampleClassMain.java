public class ExampleClassMain {
    public static void main (String args[]) {
        System.out.println("a = " + ExampleClass.a);
        ExampleClass obj1 = new ExampleClass();
        ExampleClass obj2 = new ExampleClass();
        obj1.a = 10;
        System.out.println("obj1.a = " + obj1.a);
        System.out.println("obj2.a = " + obj2.a);
        obj2.a=20;
        System.out.println("obj1.a = " + obj1.a);
        System.out.println("obj2.a = " + obj2.a);
    }
}