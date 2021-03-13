public class TestAnnotation {
  @SuppressWarnings( {
    "deprecated"
  } ) @Marker public static void main(String args[]) {
    SuperClass sc = new SuperClass();
    sc.method();
  }

  @ToComplete(
    description = "We need to do something…",
    priority = ToComplete.Priority.LOW
  )

  public void m(){}
}