import java.util.Iterator;

public class MultiPlayerGameImpl extends MultiPlayerGame {
    public void start() {
        // so far no implementation
    }

    public void play() {
        // so far no implementation
    }

    public void end() {
        // so far no implementation
    }

    public void printPlayers() {
        System.out.println("Players list:");
        for (Player player : getPlayers()) {
            System.out.println(player);
        }
    }
}