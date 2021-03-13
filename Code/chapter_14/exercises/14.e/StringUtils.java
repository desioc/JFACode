import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static List<String> search(String text, char firstCharacter) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b"+firstCharacter+"[a-zA-Z]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }
}