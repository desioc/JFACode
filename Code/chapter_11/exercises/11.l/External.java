public class External {
    private int integer = 5;

    public static void main(String[] args) {
        External.Inner inner = new External().new Inner();
        inner.innerMethod();
    }
    private class Inner extends External {
        private int integer = 10;
        protected void innerMethod() {
            System.out.println(super.integer);
            System.out.println(this.integer);
        }
    }
}