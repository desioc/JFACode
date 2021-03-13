public class StaticExample {
    private static int a = 10;
    public StaticExample(){
        a += 10;
    }
    static {
        System.out.println("static value = " + a);
    }
}