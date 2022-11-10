import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Integer round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(String.format("Element with name: %s not registered", playerName));
    }
}

