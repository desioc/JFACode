public interface SubInterface extends SuperInterface {
    //@Override
    static void staticMethod() {
        System.out.println("SubInterface.staticMethod()");
    }
}