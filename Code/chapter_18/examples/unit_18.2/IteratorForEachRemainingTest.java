import java.util.*;

public class IteratorForEachRemainingTest {
    public static void main(String args[]) {
        Collection<Smartphone> smartphones = new HashSet<>();
        smartphones.add(new Smartphone("Samsung","Note 74"));
        smartphones.add(new Smartphone("Apple","iPhone XXX"));
        smartphones.add(new Smartphone("Huawei","P100"));
        smartphones.forEach(s->System.out.println(s));
        Iterator<Smartphone> iterator = smartphones.iterator();
        iterator.forEachRemaining(element-> {
            element.setBrand("Google");
        } );
        System.out.println(smartphones);

    }
}