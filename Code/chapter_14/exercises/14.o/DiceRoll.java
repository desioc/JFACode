import java.util.Random;

public class DiceRoll {

    public static void main(String args[]) {
        System.out.println("Dice rolling... " + (1 + new Random().nextInt(6)) + "!");
    }
}