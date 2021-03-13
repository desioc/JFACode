public class OperationTest {
    public static void main(String args[]) {
        Operation<Integer, Operator> operation = new Operation<>(1, Operator.SUM, 1);
        operation.print();
    }
}