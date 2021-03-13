public enum Operator {
    
    SUM("+"), SUBTRACTION("-"), MULTIPLICATION("X"), DIVISION(":");

    String sign;

    Operator(String sign) {
        this.sign = sign;
    }
    
    public String toString(){
        return sign;
    }
}