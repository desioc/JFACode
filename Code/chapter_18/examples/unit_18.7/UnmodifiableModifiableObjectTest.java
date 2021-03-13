import java.util.*;

public class UnmodifiableModifiableObjectTest {
    public static void main(String args[]) {
        List<ModifiableObject> arrayList = new ArrayList<>();
        ModifiableObject o1 = new ModifiableObject("NAME_1");
        arrayList.add(o1);
        arrayList = Collections.unmodifiableList(arrayList);
        System.out.println("arrayList before: "+ arrayList);
        arrayList.get(0).setName("NAME_2"); // same as o1.setName("NAME_2")
        System.out.println("arrayList after: "+ arrayList);
    }
}