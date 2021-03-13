public class Exercise9Z {
    private static final String FIRST_PART_OF_THE_STRING ="The result is ";
    public static void main(String args[]) {
        SumInteger sumInteger = new SumInteger();
        System.out.println(FIRST_PART_OF_THE_STRING + sumInteger.sum(1.0, 1.0));
        System.out.println(FIRST_PART_OF_THE_STRING + sumInteger.sum(1, null));
        System.out.println(FIRST_PART_OF_THE_STRING + sumInteger.sum(1, 25));
    }
}