import java.util.*;

public class HashMapTest {
    public static void main(String args[]) {
        HashMap<Integer,String> table = new HashMap<>();
        table.put(2006,"Simone");
        table.put(2004,"Andrea");
        table.put(null,null);
        System.out.println(table.get(2004));
        System.out.println(table.get(2006));
        System.out.println(table.get(null));
        HashMap<Object,String> table2 = new HashMap<>();
        table2.put(new HashMap<String, String>(),null);
    }
}