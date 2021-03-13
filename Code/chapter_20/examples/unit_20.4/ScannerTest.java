import java.util.*;

public class ScannerTest {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            String typedText ="";
            while (sc.hasNext()) {
                typedText = sc.nextLine();
                System.out.println(typedText);
            }
        }
    }
}