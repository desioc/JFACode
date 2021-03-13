import java.util.*;
import java.util.stream.Stream;

public class IntroStreamsTest {
    public static void main(String args[]) {
        String [] stringArray = {"The ","Human","Equation"};
        Stream <String> stringsStream1 = Stream.of(stringArray);
        Stream <String> stringsStream2 = Stream.of("Take", "The", "Time");
        Stream<Double> randomDoubles = Stream.generate(Math::random);
        randomDoubles.forEach(System.out::println);
    }
}