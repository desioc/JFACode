public class Arithmetic {
    public double sum(double[] doubles) {
        double result = 0.0D;
        for (double tmp : doubles) {
            result += tmp;
        }
        return result;
    }
}