public class LambdaThis {
    private String string ="instance variable";
    public void methodWithLambda() {
        String string ="local variable of the containing method";
        new Thread(()->System.out.println(this.string)).start();
        new Thread(()->System.out.println(string)).start();
      /* new Thread(()-> {
            String string ="local variable of the lambda expression method";
            System.out.println(string);
        } ).start(); */
    }
    public static void main(String args[]) {
        LambdaThis lambdaThis = new LambdaThis();
        lambdaThis.methodWithLambda();
    }
}