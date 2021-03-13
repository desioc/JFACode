public class LocalLocalVariableTest {
    public int sum(int x, int y) {
        int z;
        int tmp;
        {
            int tmp= x + y;
            z = tmp;
        }
        tmp = z;
        return tmp;
    }
}