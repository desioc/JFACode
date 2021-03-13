import java.util.*;

public class UnmodifiableListTest {
    public static void main(String args[]) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        List<String> wrapperList = Collections.unmodifiableList(arrayList);
        //it would be better:
        //arrayList = Collections.unmodifiableList(arrayList);
        //In fact with the following line we will cause an error
        //wrapperList.add("d");
        arrayList.add("d");
        System.out.println("wrapperList has benn updated: " + wrapperList + "!");
    }
}