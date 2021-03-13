public class OwnGenericWithMinusTest {
    public static void main(String args[]) {
        OwnGeneric<String> own = new OwnGeneric<>();
        own.add("-");
        own.add("--");
        own.add("---");
        System.out.println(own);
    }
}