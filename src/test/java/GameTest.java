import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(123, "Kolya", 250);
    Player player2 = new Player(147, "Pavel", 350);
    Player player3 = new Player(155, "Irina", 100);
    Player player4 = new Player(146, "Katya", 250);
    Player player5 = new Player(111, "Igor", 351);

    @Test
    public void firstPlayerWins() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        int actual = game.round(player2.getName(), player3.getName());
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round(player1.getName(), player2.getName());
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);
        int actual = game.round(player1.getName(), player4.getName());
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondUnregisteredPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1.getName(), "Unregistered  name"));
    }

    @Test
    public void firstUnregisteredPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Unregistered  name", player2.getName()));
    }


}
