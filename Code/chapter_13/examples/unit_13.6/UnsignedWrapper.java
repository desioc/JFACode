public class UnsignedWrapper {
    public static void main(String args[]) {
        byte b = (byte)(128);
        System.out.println(Byte.valueOf(b));
        System.out.println(Byte.toUnsignedInt(b));
        int i = (int)3_000_000_000L;
        System.out.println(Integer.toUnsignedString(i, 10));
        System.out.println(Integer.toUnsignedString(i, 2));
        System.out.println(Integer.toUnsignedString(i, 8));
        System.out.println(Integer.toUnsignedString(i, 16));
    }
}