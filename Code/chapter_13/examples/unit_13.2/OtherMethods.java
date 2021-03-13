public class OtherMethods{
    public static void main(String args[]) {
        long initialTime = System.currentTimeMillis();
        System.out.println("The PATH variable value is : " + System.getenv("PATH"));
        System.out.println(System.getenv());
        System.out.println(System.lineSeparator());
        long totalTime = System.currentTimeMillis() - initialTime;
        System.out.println("Total time passed: " + totalTime + " milliseconds");
    }
}