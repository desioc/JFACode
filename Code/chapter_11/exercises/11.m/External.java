public class External {
    public int a = 1;
    private int b = 2;
    public void externalMethod(final int c) {
        int d = 4;
        class Inner {
            private void innerMethod(int e) {

            }
        }
    }
}