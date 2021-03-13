public class OuterClass {
    private int i = 0;
    class InnerClass {
        public void method(){
            System.out.println("I can access to the variable i " + i);
        }
    }
}