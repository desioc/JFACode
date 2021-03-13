import java.util.concurrent.*;

public class TestMyCallable {
    public static void main(String args[]) {
        MyCallable callable = ()-> {
            Thread.sleep(1000);
            System.out.println("Hello World");
            return null; // we need this since Void is a class
        } ;
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(callable);
        pool.shutdown();
    }
}