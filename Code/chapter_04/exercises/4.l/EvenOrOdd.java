import java.util.*;

public class EvenOrOdd {
    public String getEvenOrOdd() {
        Random random = new Random();
        return random.nextInt() % 2 == 0 ? "Even" : "Odd";
    }
}