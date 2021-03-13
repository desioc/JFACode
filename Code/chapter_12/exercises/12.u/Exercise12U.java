import java.util.List;
import java.util.Iterator;

public class Exercise12U {
    public static <T extends Number> void loop(List<T> list) {
        for (Iterator<T> i = list.iterator(); i.hasNext( ); ) {
            System.out.println(i.next());
        }
    }
}
