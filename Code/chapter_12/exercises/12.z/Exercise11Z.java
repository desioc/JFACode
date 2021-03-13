public class Exercise12Z {
    public static <E extends Exception> void printException(E e) {
        System.out.println(e.getMessage());
    } 
    public static void main(String[] args) {
        /*INSERT CODE HERE*/Exercise12Z.printException(new Throwable("Exception"));
    }
}