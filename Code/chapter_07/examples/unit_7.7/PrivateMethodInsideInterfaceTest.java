public interface PrivateMethodInsideInterfaceTest {
    default void defaultMethod() {
        privateMethod();
    }
    
    private /*default*/ void privateMethod() {
        System.out.println("Private Method invoked");
    }
}