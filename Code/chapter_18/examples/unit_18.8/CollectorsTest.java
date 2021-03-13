import java.util.*;
import java.util.stream.*;

public class CollectorsTest {
    public static void main(String args[]) {
        Collection<Smartphone> smartphones = getSmartphones();
        List<String> modelli = smartphones.stream().map(Smartphone::getModel).collect(Collectors.toList());
        modelli.forEach(System.out::println);
        System.out.println();
        Set<String> brands = smartphones.stream().map(Smartphone::getBrand).collect(Collectors.toCollection(TreeSet::new));
//       Set<String> brands = smartphones.stream().map(Smartphone::getBrand).collect(Collectors.toSet());
        brands.forEach(System.out::println);
        String modelsWithSeparator = smartphones.stream().map(Smartphone::toString).collect(Collectors.joining("; "));
        System.out.println(modelsWithSeparator);
        System.out.println();
        Map<String, List<Smartphone>> map = smartphones.stream().collect(Collectors.groupingBy(Smartphone::getBrand));
        System.out.println(map);

        DoubleSummaryStatistics stats = smartphones.stream().collect(Collectors.summarizingDouble(Smartphone::getPrice));        
        System.out.println(stats);
    }

    public static Collection<Smartphone> getSmartphones() {
        Collection<Smartphone> smartphones = new HashSet<>();
        smartphones.add(new Smartphone("Samsung","Note 74", 1620));
        smartphones.add(new Smartphone("Apple","Iphone 55",2721));
        smartphones.add(new Smartphone("Huawei","P100",1700));
        smartphones.add(new Smartphone("Samsung","S 99", 700));
        smartphones.add(new Smartphone("Samsung","J46", 925));
        smartphones.add(new Smartphone("Samsung","A27", 610));
        return smartphones;
    }
}