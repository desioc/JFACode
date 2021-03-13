import java.util.List;
import java.util.ArrayList;

public class Exercise12R<T> {
    
    private <L extends List<Integer>> Integer sumElements(L list) {
        int size = list.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            Integer item = list.get(i);
            result+=item;
        }
        return result;
    }

    public static void main(String args[]) {
        Exercise12R<Void> e = new Exercise12R<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(6);
        a.add(10);
        a.add(24);
        a.add(17);
        System.out.println("The sum of the list elements is "+ e.sumElements(a));
    }
}