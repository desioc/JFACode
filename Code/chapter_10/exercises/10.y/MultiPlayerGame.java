import java.util.List;
import java.util.ArrayList;

public abstract class MultiPlayerGame implements Game {
    private List<Player> players;

    public MultiPlayerGame () {
        init();
        start();
        play();
        end();
    }

    @Override
    public void init() {
        players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int id)  throws PlayerException {
        if (id < 0) {
            throw new PlayerException("The player ID cannot be negative");
        } else if (id >=players.size()) {
            throw new PlayerException("The player ID does not exist");
        }
        return players.get(id);
    }


    public Player getPlayer(String name) throws PlayerException {
        Player playerFound = null;
        int counter = 0;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                counter++;
                playerFound = player;
            }
        }
        if (counter == 0) {
              throw new PlayerException("Player with name " + name + " not found");
        } else if (counter > 1) {
            throw new PlayerException("Found " + counter + " players with name " + name);
        }
        return playerFound;
    }
}