import java.util.*;

public class PipelineTest {
    public static void main(String args[]) {
        Collection<Smartphone> smartphones = getSmartphones();
        double average = smartphones
        .stream()
        .filter(s -> s.getBrand().equals("Samsung"))
        .mapToDouble(Smartphone::getPrice)
        //.average().getAsDouble();
        .average().orElse(0);
        System.out.println(average);
    }

    public static Collection<Smartphone> getSmartphones() {
        Collection<Smartphone> smartphones = new HashSet<>();
        smartphones.add(new Smartphone("Samsung","Note 74", 620));
        smartphones.add(new Smartphone("Apple","Iphone 55",721));
        smartphones.add(new Smartphone("Huawei","P100",700));
        smartphones.add(new Smartphone("Samsung","S 55", 700));
        smartphones.add(new Smartphone("Samsung","Ace", 125));
        smartphones.add(new Smartphone("Samsung","Grand", 310));
        smartphones.add(new Smartphone("Samsung","Young", 80));
        smartphones.add(new Smartphone("Samsung","Express", 70)); 
        return smartphones;
    }
}