import java.util.Arrays;
import java.util.function.BiPredicate;

public class Exercise17U {
    public static void main(String args[]) {
        Person [] persons = {
            new Person("Antonio",21),
            new Person("Bruno",20),
            new Person("Giorgio",19),
            new Person("Martino",22),
            new Person("Daniele",21)
        };
        Person personWithNameThatStartsWithD = getPersonWithNameThatStartsWithD("D", persons, /*INSERT CODE HERE*/
            (String firstCharacter, Person person) -> person.getName().startsWith(firstCharacter));
        System.out.println(personWithNameThatStartsWithD);
    }
    
    static Person getPersonWithNameThatStartsWithD(String firstCharacter, Person[] persons, BiPredicate<String, Person> biPredicate){
        for(Person person : persons) {
            if (biPredicate.test(firstCharacter, person)) {
                return person;
            }
        }
        return null;
    }
}