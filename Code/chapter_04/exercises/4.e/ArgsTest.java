public class ArgsTest {
    public static void main(String args[]) {
        if (args.length == 1) {
            System.out.println(args[0]);
        } else {
            System.out.println("Please, specify a value from the command line");
        }
    }
}