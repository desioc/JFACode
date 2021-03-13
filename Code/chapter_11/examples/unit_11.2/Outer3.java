public class Outer3 {
    private String message ="In the class ";
    private void printMessage() {
        System.out.println(message+"Outer");
    }
    //Declaration and instance of the anonymous class
    ExistingClass ec = new ExistingClass() {
        @Override
        public void method() {
            System.out.println(message+"anonymous");
        }
    }; //Note the ";"
    //. . .
}