public class Outer4 {
    private String message ="In the class ";

    public void methodWithClass(final int a) {
        ExistingClass ec = new ExistingClass() {
            @Override
            public void method() {
                System.out.println(message+"anonymous number "+ a);
            }
        } ;
        ec.method();
    }
}