public class ParentInitializer {
    public ParentInitializer () {
        System.out.println("ParentInitializer constructor");
    }
    {
        System.out.println("ParentInitializer initializer");
    }

    static {
        System.out.println("ParentInitializer static initializer");
    }
}