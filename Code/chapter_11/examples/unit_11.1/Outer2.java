public class Outer2 {
    private String string = "outer";
    public class Inner2 {
        private String string = "inner";
        public void methodInner() {
            System.out.println(Outer2.this.string +
            " " + this.string);
        }
    }
    public static void main(String [] args) {
        Outer2 outer = new Outer2();
        Outer2.Inner2 inner = outer.new Inner2();
        inner.methodInner();
    }
}