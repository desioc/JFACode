public class Arithmetic {
    public int sum(int a, int b) {
        return a + b;
    }
    public float sum(int a, float b) {
        return a + b;
    }
    public float sum(float a, int b) {
        return a + b;
    }
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
    public double sum(int a, double b, int c) {
        return a + b + c;
    }
    //Varargs example
    public double sum(double... doubles) {
        double result = 0.0D;
        for (double tmp : doubles) {
            result += tmp;
        }
        return result;
    }
}