import java.util.*;

public class SortingTes {
    public static void main(String args[]) {
        String [] names = {"Marcello","Serena","Antonio"} ;
        System.out.println("Array not ordered:");
        printArray(names);
        Arrays.sort(names);
        System.out.println("\nArray ordered:");
        printArray(names);
        
        List<String> nameList = new ArrayList<String>(Arrays.asList(names));
        System.out.println("List not ordered:");
        printList(nameList);
        Collections.sort(nameList, new StringComparator());
        System.out.println("List ordered with reverse strings:");
        printList(nameList);
    }

    public static void printList(List<String> list) {
        for (String name: list) {
            System.out.println(name);
        }
    }

    public static void printArray(String array[]) {
        for (String name: array) {
            System.out.println(name);
        }
    }
}