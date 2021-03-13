import java.util.*;

@SuppressWarnings({"rawtypes"})
public class Exercise16O {
    
    List objects;

//    @SuppressWarnings({"rawtypes"})
    public Exercise16O(){
        objects = new ArrayList();
        
    }
    
//    @SuppressWarnings({"rawtypes"})
    public void remove(Object object) {
        Iterator iterator = objects.iterator();
        if (iterator.hasNext()) {
            Object item = iterator.next();
            if (object.toString().equals(item.toString())) {
                iterator.remove();
            }
        }
    }
}