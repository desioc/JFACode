public class GreetingsFromAliens {
    public static void main(String args[]) {
        String arg = "humans";
        if (args.length != 0) {
            arg = args[0];
        }
        System.out.println("Greetings " +  arg + "!");
    }
}