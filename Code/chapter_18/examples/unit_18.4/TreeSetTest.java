import java.util.*;
public class TreeSetTest {
    public static void main(String args[]) {
/* ArrayList <String>list = new ArrayList<>(/* Arrays.asList(new String[]{"c","a","b","b", null, null}) );
        list.add("c");
        list.add("a");
        list.add("b");
        list.add("b"); 
        list.add(null);
        list.add(null); 
        Set<String> set = new HashSet<>(list);     
        set.forEach(System.out::println); */

        /* Set<Integer> ints = new TreeSet<>();
        ints.add(1);
        ints.add(4);
        ints.add(178);
        ints.add(179); 
        ints.add(178);
        ints.add(279); 
        ints.add(78);
        ints.add(177); 
        ints.forEach(System.out::println); */

        /* Set<String> set = new TreeSet<>((x,y)-> { return -(x.compareTo(y)); } );
        set.add("c");
        set.add("a");
        set.add("Z");
        set.add("b");
        set.add("B");
        set.add("b"); 
        set.add("A"); 
        set.add("$"); 
        set.add("AZ"); 
        set.forEach(System.out::println); */


        Set<NonComparableElement> notComparableElementsSet = new TreeSet<>();
        notComparableElementsSet.add(new NonComparableElement("1"));
    }
    static class NonComparableElement {
        String id;
        NonComparableElement(String id) {
            this.id = id;
        }

        public String toString() {
            return id;
        }
    }
}