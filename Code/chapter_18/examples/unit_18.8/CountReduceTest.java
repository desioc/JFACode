import java.util.*;

public class CountReduceTest{
    public static void main(String args[]) {
        Collection<Smartphone> smartphones = getSmartphones();
        long count = smartphones.stream().filter(s -> s.getBrand().equals("Samsung")).count();
        System.out.println(count);
        long totalPrice = smartphones.stream().filter(s -> s.getBrand().equals("Samsung")).map(Smartphone::getPrice).reduce(0, (x,y) -> x+y);
//        long totalPrice = smartphones.stream() .filter(s -> s.getBrand().equals("Samsung")) .map(Smartphone::getPrice).reduce(0, Integer::sum);

        System.out.println(totalPrice);        
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