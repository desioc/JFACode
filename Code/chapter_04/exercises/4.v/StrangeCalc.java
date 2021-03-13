public class StrangeCalc {

    public double sum(double... doubles) {
        double result = 0;
        for (double aDouble : doubles) {
            result += aDouble;
        }
        return result;
    }

    public double multiply(double... doubles) {
        double result = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
           result *= doubles[i];
        }
        return result;
    }

    public double maximum(double... doubles) {
        double max = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            double aDouble = doubles[i];
            if (aDouble > max) {
                max = aDouble;
            }
        }
        return max;
    }

    public double minimum(double... doubles) {
        double min = doubles[0];
        for (int i = 1; i < doubles.length; i++) {
            double aDouble = doubles[i];
            if (aDouble < min) {
                min = aDouble;
            }
        }
        return min;
    }

}