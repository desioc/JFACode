import java.lang.reflect.*;
import java.util.*;

public class AnnotationsPublisher {
  public static void main(String[] args) throws Exception {
    Map<String,String> map = new HashMap<>();
    Method[] methods = Class.forName("Test").getMethods();
    for (Method m : methods) {
      ToComplete dc = null;
      if ((dc = m.getAnnotation (ToComplete.class)) != null) {
        String description = dc.description();
        String assignedTo = dc.assignedTo();
        map.put(description, assignedTo);
      }
    }
    publishToIntranet(map);
  }

  public static void publishToIntranet(Map <String,String>map) {
    Set <String>keys = map.keySet();
    for (String key : keys) {
      System.out.printf("Description = %s; Assigned a:%s", key, map.get(key));
    }
  }
}