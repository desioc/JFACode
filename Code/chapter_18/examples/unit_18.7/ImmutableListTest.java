import java.util.*;

public class ImmutableListTest {
    public static void main(String args[]) {
        /* List<String> immutableList = Arrays.asList("a","b","c");
        immutableList = Collections.unmodifiableList(immutableList); */
        List<String> immutableList = List.of("a", "b", "c");
    }
}