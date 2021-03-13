import java.util.Arrays;

public class Exercise17S {
    public static void main(String args[]) {
        Person [] persons = {
            new Person("Antonio",21),
            new Person("Bruno",20),
            new Person("Giorgio",19),
            new Person("Martino",22),
            new Person("Daniele",21)
        };
        Arrays.sort(persons, /*INSERT CODE HERE*/Person::compareTo);
        System.out.println(Arrays.toString(persons));
    }
}