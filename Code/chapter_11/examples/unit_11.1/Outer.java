public class Outer {
    private String message = "In the class ";
    private void printMessage() {
        System.out.println(message + "Outer");
    }
    /* the inne class can use the members declared by the containing class*/
    public class Inner {
        // inner class
        public void method() {
            System.out.println(message + "Inner");
        }
        public void callMethod() {
            printMessage();
        }

        //property 5 sample
        private String stringOuter = "JAVA";
        public void methodOuter() {
            int intMethod = 7;
            class Inner2 {
                public void methodInner() {
                    System.out.println(stringOuter + " " + (++intMethod));
                }
            }
        }
        //. . .
    }
    //. . .
}