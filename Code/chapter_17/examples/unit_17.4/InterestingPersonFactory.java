//import java.util.function.*;
public class InterestingPersonFactory {
    public static Thinker getInterestingPerson() {
        Thinker thinker = (Reader & Programmer & Thinker /*& Predicate*/) () -> "Eureka!";
        return thinker;
//        return (Reader & Programmer & Thinker) () -> "Eureka!";
    }
    
    public static <T extends Thinker & Programmer & Reader> T getVeryInterestingPerson() {
        return (T)(Thinker & Programmer & Reader)() -> "Eureka!";
    } 
}