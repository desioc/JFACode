import java.util.function.BiFunction;
public class BiFunctionTest {
    public static void main(String args[]) {
        BiFunction<String,String,String> concatenationWithDash = (String s1, String s2) -> { return s1 + "-" + s2; };
        System.out.println(transformStrings("Andrea","Simone",concatenationWithDash));
    }

    public static String transformStrings(String s1, String s2, BiFunction<String, String, String> biFunction) {
        return biFunction.apply(s1,s2);
    }
}