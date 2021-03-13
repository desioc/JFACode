public class SumInteger extends SumNumber{
    @Override
    public Integer sum(Number n1, Number n2) {
        return (Integer)n1 + (Integer)n2;
    }
    
    public static void main(String args[]) {
        SumInteger sumInteger = new SumInteger();
        sumInteger.sum(1.0, 1.0);
    }
}