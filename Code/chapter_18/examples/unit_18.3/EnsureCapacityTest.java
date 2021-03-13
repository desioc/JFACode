import java.util.*;

public class EnsureCapacityTest {
    public static void main(String args[]) {
        //initial capacity 1
        ArrayList<String> list = new ArrayList<>(1);
        long startTime = System.currentTimeMillis();
        //list.ensureCapacity(100000000);
        for (int i = 0; i < 100000000; i++) {
            list.add("nuovo elemento");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time = "+ (endTime - startTime));
    }
}