package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Petr", 100);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Ivan", "Petr");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Petr", 150);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Ivan", "Petr");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothOfPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Petr", 150);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Ivan", "Petr");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Petr", 150);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Petr")
        );
    }

    @Test
    public void testWhenSecondPlayerNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Petr", 150);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Oleg")
        );
    }

    @Test
    public void testWhenBothPlayerNotRegister() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Petr", 150);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Gleb", "Oleg")
        );
    }

}
