public interface F extends E {
    @Override
    default void m() {
        System.out.println("Within the B interface");
    }
}