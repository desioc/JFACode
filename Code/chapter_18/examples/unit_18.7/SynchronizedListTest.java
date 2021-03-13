import java.util.*;

public class SynchronizedListTest {
    public static void main(String args[]) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        List<String> synchList = Collections.synchronizedList(arrayList);
        Collection<String> c = Collections.synchronizedCollection(synchList);
        synchronized(c) {
            Iterator<String> iterator = c.iterator();
            while (iterator.hasNext())
            doSomething(iterator.next());
        }
    }
    
    public static void doSomething (String string) {
    
    }
}