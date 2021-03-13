import java.util.*;

public class ConvenienceMethodsTest {
    public static void main(String args[]) {
        Collection<Object> collection = new ArrayList<>();
        Object objectToRemove = new Object();
        collection.add(objectToRemove);
        collection.add(null);
        collection.add(null);
        collection.removeAll(Collections.singleton(objectToRemove));
        System.out.println(collection);
        collection.removeAll(Collections.singleton(null));    
        System.out.println(collection);
    }
}