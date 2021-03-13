import java.util.*;

public class Exercise12O {

    public static int getSize(List/*INSERT CODE HERE*/ list) {
        return list.size();
    }

    public static void main(String args[]) {
        System.out.println(getSize(new ArrayList<Integer>()));
        System.out.println(getSize(new ArrayList<HashMap<String, List<String>>>()));
    }
}
