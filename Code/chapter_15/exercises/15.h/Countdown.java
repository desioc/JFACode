public class Countdown {
    
    public void run(int seconds) throws InterruptedException {
        for (int i = seconds; i > 0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }       
        System.out.println("Time out!");
    }
}