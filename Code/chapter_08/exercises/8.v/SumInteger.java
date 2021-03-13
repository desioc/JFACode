public class SumInteger extends SumNumber{
    @Override
    public Integer sum(Number n1, Number n2) {
        if (n1 == null || n2 == null) {
            System.out.println("Impossible to sum a null operand, " + 
                "retrieving the default value");
            return Integer.MIN_VALUE;
        } else if (!(n1 instanceof Integer && n2 instanceof Integer)){
            System.out.println("Pass integer variables only, " +
                "retrieving the default value");
            return Integer.MIN_VALUE;
        }
        return (Integer)n1 + (Integer)n2;
    }
    
    public static void main(String args[]) {
        SumInteger sumInteger = new SumInteger();
        sumInteger.sum(1.0, 1.0);
        sumInteger.sum(null, 1.0);
    }
}