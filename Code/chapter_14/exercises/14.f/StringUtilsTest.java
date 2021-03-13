import java.util.List;

public class StringUtilsTest {

    public static void main(String args[]) {
        List<String> list = StringUtils.search(
                "The smile of dawn arrived early May "
                + "she carried a gift from her home "
                + "the night shed a tear to tell her of fear "
                + "and of sorrow and pain she'll never outgrow ", 't');
        for (String string : list) {
            System.out.println(string);
        }
    }
}