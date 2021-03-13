public interface Programmer {
    default void program(String language) {
        System.out.println("I'm programming with " + language);
    }
}