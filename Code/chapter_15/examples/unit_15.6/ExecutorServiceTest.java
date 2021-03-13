import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String args[]) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i =0; i<100; i++) {
            Future<Integer> future = service.submit(new Process(i));
            System.out.println(" Value : "+future.get());
        }
        service.shutdownNow();
    }
}

class Process implements Callable<Integer> {
    private int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public synchronized Integer call() {
        System.out.print("ID : "+ this.id +", thread :  "+  Thread.currentThread().getName());
        return this.id;
    }
}