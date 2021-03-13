import java.util.List;

public class Solution12V {
    protected final void update(List<?> list) {
        helperMethod(list);
    }
    
    private <T> void helperMethod(List<T> list){
        list.add(list.get(0));
    }
}