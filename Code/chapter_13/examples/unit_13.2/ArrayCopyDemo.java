import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int even[] = {2, 4, 6, 8, 10} ;
        int odd[] = {1, 3, 5, 7, 9} ;
        System.arraycopy(even, 2, odd, 1, 2);
        System.out.print(Arrays.toString(odd));
    }
}