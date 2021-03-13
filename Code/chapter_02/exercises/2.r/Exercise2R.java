public class Exercise2R {
    public int var1;
    public int var2;

    System.out.println("Exercise 2.r");

    public Exercise2R () {

    }

    public Exercise2R (int a , int b) {
        var1 = b;
        var2 = a;
    }

    public static void main(String args[]) {
        Exercise2R exercise2R = new Exercise2R (4,7);
        System.out.println(exercise2R.var1);
        System.out.println(exercise2R.var2);
    }
}