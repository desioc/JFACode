public class OuterAnonymous {
    private String message ="In the class ";

    //Declaration and instance of the anonymous class
    ExistingClass ec = new ExistingClass() {
        @Override
        public void method() {
            System.out.println(message+"anonymous");
        }

        public void nonInvocableMethod() {
            System.out.println("There is no reference for an anonymous class: this method can not be called!");
        }
    } ; //Note the ";"
    //. . .
    public static void main(String args[]) {
        new OuterAnonymous();
    }

    public OuterAnonymous() {
        ec.method();
    }
}