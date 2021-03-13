public class ResultFloatTest {
    public static void main(String args[]) {
        float result = 5.0F;
        System.out.println(result);
        ChangeResult cr = new ChangeResult();
        result = cr.changeResult(result);
        System.out.println(result);
    }
}