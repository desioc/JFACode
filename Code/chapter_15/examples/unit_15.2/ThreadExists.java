public class ThreadExists {
    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        t.setName("Main thread");
        t.setPriority(10);
        System.out.println("Running thread: "+ t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(""+ n);
                t.sleep(1000);  
            }
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            
        }
    }
}