public class CountTest {
    private int count;
    public CountTest (int count){
        this.count = count;
    } 
    public void startCount() {
//        int count = 0;
        new Thread(() -> {
            while (count  < 100) {
               System.out.println(count);
            }
        });
    }
}