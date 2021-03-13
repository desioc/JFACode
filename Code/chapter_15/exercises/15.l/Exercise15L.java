import java.util.Scanner;

public class Exercise15L {
    public static void main(String args[]) {
        Runner runner = new Runner();
        runner.startTraining();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println(
           "Hi coach, the runner is at your disposal!");
        System.out.println("Write the commands then press the Enter key");
        System.out.println("(run, walk, stop, end)");
        while (loop) {
            
            String command = scanner.nextLine();
            switch (command) {
                case "run":
                    runner.startRunning();
                break;
                case "walk":
                    runner.walk();
                break;
                case "stop":
                    runner.takeABreath();
                break;
                case "end":
                    runner.stopTraining();
                    loop = false;
                break;
                default:
                    runner.cannotUnderstand(command);
                break;
            }
        }
        try {
            Thread.sleep(2000);
        }
        catch (Exception exc) {
            assert false;
        }
        System.out.println("End of the training");
    }
}