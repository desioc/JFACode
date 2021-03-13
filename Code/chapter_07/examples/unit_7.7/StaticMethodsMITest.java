public class StaticMethodsMITest extends A3 implements I1 , I2 {
    public static void main(String args[]) {
        staticMethod();
        /* I1.staticMethod();
        I2.staticMethod(); */
    }
/* public static void staticMethod(){
        System.out.println("StaticMethodsMITest");
    } */

}


interface I1 {
    public static void staticMethod() {
        System.out.println("Interface I1");    
    }

}
interface I2 extends I1 {
    public static void staticMethod(){
        System.out.println("Interface I2");
    }
}
class A3 {
    public static void staticMethod() {
        System.out.println("Abstract class");
    }
}