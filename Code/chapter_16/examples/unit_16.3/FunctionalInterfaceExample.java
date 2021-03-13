@FunctionalInterface
public interface FunctionalInterfaceExample {
    int abstractMethod();
//    void secondAbstractMethod();
    default void defaultMethod(){
        System.out.println("default method");
    }
}