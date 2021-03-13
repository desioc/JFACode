import java.util.*;

public class ArrayListContainsTest {
    public static void main(String args[]) {
        ArrayListContains arrayListContains1 = (al, n)-> al.contains(n);
        ArrayListContains arrayListContains2 = (ArrayList<Number> al, Number n)-> al.contains(n);
        ArrayListContains arrayListContains3= (var al, var n)-> al.contains(n);
//        ArrayListContains arrayListContains4 = (List<Number> al, Number n)-> al.contains(n);
//        ArrayListContains arrayListContains5= (ArrayList<Number> al, Integer n)-> al.contains(n);
    }
}