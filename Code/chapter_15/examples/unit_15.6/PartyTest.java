import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PartyTest {
    public static void main(String args[]) {
        CyclicBarrier placeOfTheParty = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Everybody present, we can start!");
            }
        } );
        Party party = new Party(placeOfTheParty);
        new Thread(party,"Antonio").start();
        new Thread(party,"Marcello").start();
        new Thread(party,"Serena").start();
    }
}