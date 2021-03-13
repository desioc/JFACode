import java.util.*;
import java.util.stream.*;

public class Exercise18V {

    public static void main(String args[]) {
        List<String> stringList = getStringList();
        Map<String, List<String>> map = stringList.stream().collect(Collectors.groupingBy(s -> (""+s.charAt(0)).toLowerCase()));
        System.out.println(map);
    }
   
   public static List<String> getStringList() {
        String string ="The children lovers embrace upright "
        +"Against night’s doors "
        +"And passers-by who pass by point their finger at them "
        +"But the children lovers "
        +"Are there for no one "
        +"And it’s only their shadow "
        +"Which quivers in the night "
        +"Stirring up the anger of the passers-by "
        +"Their anger, their contempt, their laughs and their desire "
        +"The children lovers are there for no one "
        +"They’re elsewhere much further than the night "
        +"Much higher than the day "
        +"In the dazzling light of their first love. ";
        String[] strings = string.split(" ");
        return Arrays.asList(strings);
    }
}