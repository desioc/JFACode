import java.util.*;

public class ArrayListTest {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>(10);
        list.add("First element");
        list.add("Second element");
        String firstElement = list.get(0);
        System.out.println(firstElement);
        System.out.println(Arrays.toString(list.toArray()));
        for (Object object : list) {
            System.out.println(object);
        }
    }
}