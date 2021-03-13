import java.util.*;

public class SynchronizedMapTest {
    public static void main(String args[]) {
        HashMap myHashMap = new HashMap();
        Map map = Collections.synchronizedMap(myHashMap);
        Set set = map.keySet();
        synchronized (map) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext())
            doSomething (iterator.next());
        }
    }

    public static void doSomething (Object string) {

    }
}