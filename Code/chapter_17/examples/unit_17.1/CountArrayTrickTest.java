public class CountArrayTrickTest {
    public void startCount() {
        int count = 0;
        int array[] = new int[1];
        array[0] = count;
        new Thread(() -> {
            while (array[0] < 100) {
               System.out.println(array[0]++);
            }
        }).start();
    }
}