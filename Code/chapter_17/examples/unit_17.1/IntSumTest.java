public class IntSumTest {
    public static void main(String args[]) {
        IntSum intSum1 = (op1, op2)->op1+op2;
        IntSum intSum2 = (int op1, int op2)->op1+op2;
        IntSum intSum3 = (var op1, var op2)->op1+op2;
//        IntSum intSum4 = (op1, int op2)->op1+op2;
//        IntSum intSum5 = (var op1, op2)->op1+op2;
//        IntSum intSum6 = (var op1, int op2)->op1+op2;
//        IntSum intSum7 = (byte op1, byte op2)->op1+op2;
//        IntSum intSum8 = (long op1, long op2)->(int)(op1+op2);
        IntSum intSum9 = (Integer op1, Integer op2)->op1+op2;
        //esempio anche su  classi e sottoclassi 
    }
}