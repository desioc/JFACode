import java.util.*;

public class TypeInferenceMethod {
    public static void main(String args[]) {
        ArrayList<Number> arrayList = new ArrayList<>();
        arrayList.add(new Integer(1));
        //arrayList.add(new ArrayList<>()); this does not compile
    }
}