import java.util.Random;

public class Exercise13Z {
    public static void main(String args[]) {
        int id = getId(args);
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        rockPaperScissors.play(id);
    }

    public static int getId(String args[]) {
        int id = 0;
        if (args.length != 0) {
            try {
                id = Integer.parseInt(args[0]);
                if (id < 0 || id > 2) {
                    System.out.println("Enter a number between 0 and 2");
                    System.exit(1);
                }
            } catch (Exception exc) {
                System.out.println("Input not valid: "+ args[0]);
                System.exit(1);
            }
        } else {
            id = new Random().nextInt(3);
        }
        return id;

    }
}