public class Exercise11N {
    
    public static void main(String args[]) {
        new MyInterface(){
            public void method(){
                System.out.println("Anonymous class");
            }
        }.method();
    }
    
    private interface MyInterface{
        void method();
    }
}