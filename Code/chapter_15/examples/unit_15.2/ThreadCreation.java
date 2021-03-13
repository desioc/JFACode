public class ThreadCreation implements Runnable {
    public ThreadCreation() {
        Thread ct = Thread.currentThread();
        ct.setName("Main thread");
        Thread t = new Thread(this,"Child thread");
        System.out.println("Current thread: "+ ct);
        System.out.println("Thread created: "+ t);
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            
        }
        System.out.println("Main thread exit");
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(""+ i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child thread exit");
    }

    public static void main(String args[]) {
        new ThreadCreation();
    }
}