import java.util.concurrent.Semaphore;

public class Crossroads {
    Semaphore semaphore = new Semaphore(1);

    public void mindTheSemaphore() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() +" is passing the crossroads");
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() +" has passed the crossroads");
        }
    }

    public static void main(String args[]) {
        Crossroads crossroads = new Crossroads();
        Thread t1 = new Thread(new Vehicle(crossroads),"A Ford");
        t1.start();
        Thread t2 = new Thread(new Vehicle(crossroads),"A Nissan");
        t2.start();
    }
}