public class FloatingPointPrecisionTest {
    public static void main(String args[]) {
        int i = 123456789;
        float f = i;
        System.out.println(f);
        System.out.println((int)f);
        
        long l = 9999999999999991L;
        double d = l;
        System.out.println(d);
        System.out.println(l - (long)d);  
        
        System.out.println((0.1+0.2));
    }
}