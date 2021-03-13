public class SimpleCalc {

    public double sum(double d1, double d2) {
        return d1 + d2;
    }

    public double subtract(double d1, double d2) {
        return d1 - d2;
    }

    public double multiply(double d1, double d2) {
        return d1 * d2;
    }

    public double divide(double d1, double d2) {
        return d1 / d2;
    }

    public double returnRest(double d1, double d2) {
        return d1 % d2;
    }

    public double maximum(double d1, double d2) {
        return d1 > d2 ? d1 : d2;
    }

    public double minimum(double d1, double d2) {
        return d1 > d2 ? d2 : d1;
    }

}