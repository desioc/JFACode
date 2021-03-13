public class External {
    private final static String string = "Nested class";
    
    protected  External() {
        private static class Nested {
            protected void method() {
                System.out.println(string);
            }
        }
    }
}