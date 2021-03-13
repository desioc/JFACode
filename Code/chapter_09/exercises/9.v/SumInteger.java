public class SumInteger extends SumNumber {
    @Override
    public Integer sum(Number n1, Number n2) {
        Integer result = null;
        try {
            result = (Integer)n1 + (Integer)n2;
        } catch (NullPointerException e) {
            System.out.println("Impossible to sum a null operand");
        } catch (ClassCastException e) {
            System.out.println("Pass only integer variables");
        }
        return result;
    }
}