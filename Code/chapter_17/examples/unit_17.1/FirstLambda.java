public class FirstLambda {
    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before 8: Anonymous Class");
            }
        } ).start();
        Runnable r = ()->System.out.println("Java 8: Anonymous function");
        //new Thread(r).start();        
        new Thread(()->System.out.println("Java 8: Anonymous function")).start();
        //var r = ()->System.out.println("Java 8: Anonymous function");
    }
}