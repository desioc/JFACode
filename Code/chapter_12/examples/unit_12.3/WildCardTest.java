import java.util.*;

public class WildCardTest {
    void test(List<?> list) {
        testHelper(list);
    }
    //Helper method
    private <T> void testHelper (List<T> list) {
        list.set(0, list.get(0));
    }
}