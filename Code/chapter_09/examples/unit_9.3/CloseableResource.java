public class CloseableResource implements AutoCloseable {
    public void close() {
        System.out.println("close() method invoked");
    }
    
    public void launchException() {
        int i = 0;
        i = 2/i;
    }

    public String toString() {
        return "CloseableResource";
    }
}