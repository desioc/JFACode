public class AsynchronousGreeting extends Greeting {
    @Override
    public void greet() {
        new Thread(super::greet).start();
    }
    
    public static void main(String args[]) {
        new AsynchronousGreeting().greet();
    }
}