import java.util.*;

public class OwnGeneric<E> {
    private List<E> list;
    public OwnGeneric () {
        list = new ArrayList<E>();
    }
    public void add(E e) {
        list.add(e);
    }
    public void remove(int i) {
        list.remove(i);
    }
    public E get(int i) {
        return list.get(i);
    }
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(get(i) + (i != size - 1 ? "-" : ""));
        }
        return sb.toString();
    }
}