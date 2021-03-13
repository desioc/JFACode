import java.util.Scanner;

public class MultiPlayerGameConfigurator implements Configurator {
    private static int counter;
    private Scanner scanner;
    private MultiPlayerGameImpl game;
    
    public MultiPlayerGameConfigurator() {
        game = new MultiPlayerGameImpl();
        scanner = new Scanner(System.in);
        config();
        game.printPlayers();
    }

    @Override
    public void config() {
        var players = game.getPlayers();
        System.out.println("Enter player name "+ (++counter) + (players.isEmpty() ?"":" Or 'i' to start playing"));
        String text = scanner.next();
        if (!players.isEmpty() && text.equals("i")) {
            return;
        }
        game.addPlayer(new Player (counter, text));
        config();
    }
}