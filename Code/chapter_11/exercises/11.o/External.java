public class External {   
    private class Inner {
        private static int effectivelyFinalVariable = 10;
        Inner() {
            effectivelyFinalVariable = 11;
        }
        protected void method() {
            System.out.println(effectivelyFinalVariable);
        }
    }
}