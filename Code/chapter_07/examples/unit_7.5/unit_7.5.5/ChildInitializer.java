public class ChildInitializer extends ParentInitializer {
    public ChildInitializer (){
        System.out.println("ChildInitializer constructor");
    }
    {
        System.out.println("ChildInitializer initializer");
    }

    static {
        System.out.println("ChildInitializer static initializer");
    }
    public static void main(String args[]) {
        new ChildInitializer();
    }
}