public class ResultTest {
    public static void main(String args[]) {
        Result result = new Result(5.0F);
        result.print();
        ChangeResult cr = new ChangeResult();
        cr.changeResult(result);
        result.print();
    }
}