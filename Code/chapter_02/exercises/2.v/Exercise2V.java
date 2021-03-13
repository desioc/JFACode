public class Exercise2V {
    public int sum2Int(int a, int b) {
        return a+b;
    }

    public int sum5Int(int a, int b, int c, int d, int e) {
        return a+b+c+d+e;
    }


    public int sum10Int(int a, int b, int c, int d, int e,int f, int g, int h, int i, int l) {
        return a+b+c+d+e+f+g+h+i+l;
    }

    //Just for test
    public static void main(String args[]) {
        Exercise2V ex = new Exercise2V();
        System.out.println(ex.sum2Int(1,1));
        System.out.println(ex.sum5Int(1,1,1,1,1));
        System.out.println(ex.sum10Int(1,1,1,1,1,1,1,1,1,1));
    }
}