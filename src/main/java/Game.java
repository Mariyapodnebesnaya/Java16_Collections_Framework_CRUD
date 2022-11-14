import java.util.HashMap;

public class Game {
    protected HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
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
        Player player = players.get(playerName);
        if (player == null) {
            throw new NotRegisteredException(String.format("Element with name: %s not registered", playerName));
        }
        return player;
    }
}

