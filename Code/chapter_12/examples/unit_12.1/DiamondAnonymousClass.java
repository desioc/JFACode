import java.util.*;

public class DiamondAnonymousClass {
    List<Integer> lista = new ArrayList<>(){
        @Override
        public boolean add(Integer i) {
            if (contains(i)) {
                return false;
            }
            return super.add(i);
        }
    };
}