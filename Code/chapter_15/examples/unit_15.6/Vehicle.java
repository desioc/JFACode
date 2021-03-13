import java.util.concurrent.Semaphore;

public  class Vehicle implements Runnable {
    private Crossroads crossroads;
    public Vehicle(Crossroads crossroads) {
        this.crossroads = crossroads;
    }

    public void run() {
        crossroads.mindTheSemaphore();
    }
}