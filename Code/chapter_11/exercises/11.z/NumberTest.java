/**
  * Class that tests the number enumeration.
  */
public class NumberTest {
    public static void main (String args []) {
        for (Object object: Number.values ()) {
            System.out.println (object);
        }
    }
}