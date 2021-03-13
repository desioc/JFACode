import java.util.concurrent.locks.*;
import java.util.concurrent.*;

public class LockExample implements Runnable {
    private int integerNumber;
    private Lock lock;

    public LockExample(int integerNumber) {
        this.integerNumber = integerNumber;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)) {
                integerNumber++;
                System.out.println("In lock "+integerNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Out lock "+integerNumber);
    }
}