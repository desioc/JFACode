import java.util.*;

public class ImmutableSetTest {
    public static void main(String args[]) {
        /* Set<String> immutableSet = new HashSet<>();
        immutableSet.add("a");
        immutableSet.add("b");
        immutableSet.add("c");
        immutableSet = Collections.unmodifiableSet(immutableSet); */
        /* Set<String> immutableSet = new HashSet<>(Arrays.asList("a","b","c"));
        immutableSet = Collections.unmodifiableSet(immutableSet); */
        Set<String> immutableSet = Set.of("a", "b", "c");
        //this instruction will launch an java.lang.UnsupportedOperationException at runtime
        //immutableSet.add("d");
        //this instruction will launch an IllegalArgumentException at runtime   
        //Set<String> immutableSet = Set.of("a", "b", "c");        
    }
}