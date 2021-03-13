public class ValuesEnumTest {
    public static void main(String args[]) {
        for (MyEnumeration2 myEnumeration : MyEnumeration2.values()) {
            System.out.println(myEnumeration+ "  is in position "  + myEnumeration.ordinal());
        }
    }
}