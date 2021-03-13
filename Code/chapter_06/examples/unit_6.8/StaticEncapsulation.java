public class StaticEncapsulation {
    private static int staticAttribute = 0;
    public static void setStaticAttribute(int staticAttribute) {
        this.staticAttribute = staticAttribute;
    }
    public static int getStaticAttribute() {
        return staticAttribute;
    }
}