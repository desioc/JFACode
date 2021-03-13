import java.util.concurrent.*;

public class WithoutMyCallableTest {
    public static void main(String args[]) {
        Callable<Void> callable = ()-> {
            Thread.sleep(1000);
            System.out.println("Hello World");
            return null;
        } ;

    }
}