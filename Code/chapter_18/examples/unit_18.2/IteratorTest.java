import java.util.*;

public class IteratorTest {
    public static void main(String args[]) {
        Collection<String> progBands = new HashSet<>();
        progBands.add("Dream Theater");
        progBands.add("Ayreon");
        progBands.add("Pain Of Salvation");
        Iterator<String> iterator = progBands.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            System.out.println(iterator.getClass().getName());
        }
    }
}