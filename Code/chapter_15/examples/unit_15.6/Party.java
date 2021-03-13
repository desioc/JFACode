import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Party implements Runnable {
    private CyclicBarrier placeOfTheParty;

    public Party(CyclicBarrier placeOfTheParty) {
        this.placeOfTheParty = placeOfTheParty;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is present");
            placeOfTheParty.await();
            System.out.println(Thread.currentThread().getName() + " started celebrating...");
        } catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }
}