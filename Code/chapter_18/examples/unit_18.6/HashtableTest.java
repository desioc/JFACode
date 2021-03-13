import java.util.*;

public class HashtableTest {
    public static void main(String args[]) {
        Hashtable<Integer, Boolean> ht = new Hashtable<>();
        ht.put(1, true);
        ht.put(2, true);
        ht.put(1, false);
        //ht.put(3, null);
        Enumeration<Integer> enumeration = ht.keys();
        while (enumeration.hasMoreElements()) {
            System.out.println(ht.get(enumeration.nextElement()));
        }
    }
}