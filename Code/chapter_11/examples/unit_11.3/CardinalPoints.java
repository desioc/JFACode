public enum CardinalPoints {
    NORTH {
        @Override
        public void test() {
            System.out.println("method of the NORTH element");
        }
    } ,
    SOUTH, WEST, EAST;
    public void test() {
        System.out.println("method of the enum");
    }
}