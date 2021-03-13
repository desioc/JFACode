public enum MyEnumeration2 implements Numerator {
    ONE, TWO, THREE;
    @Override
    public void printIndex() {
            System.out.println("index: " + this.ordinal());
    }
}