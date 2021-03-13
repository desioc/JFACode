import java.util.*;

public class StreamsTest {
    public static void main(String args[]) {
        Collection<Smartphone> smartphones = new HashSet<>();
        smartphones.add(new Smartphone("Samsung", "Note 74"));
        smartphones.add(new Smartphone("Apple", "Iphone 225"));
        smartphones.add(new Smartphone("Huawei", "P100"));
        smartphones.forEach(s->System.out.println(s));
//        smartphones.stream().filter(s->"Samsung".equals(s.getBrand())).forEach(s->System.out.println(s));
//        smartphones.parallelStream().filter(s->"Samsung".equals(s.getBrand())).forEach(s->System.out.println(s));
    }
}

