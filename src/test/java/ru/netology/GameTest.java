package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    @Test
    public void WhenWinFirstPlayer() {
        Player andrey = new Player(1, "Андрей", 100);
        Player victor = new Player(2, "Виктор", 80);
        Game game = new Game();

        game.register(andrey);
        game.register(victor);
        int actual = game.round("Андрей", "Виктор");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenWinSecondPlayer() {
        Player andrey = new Player(1, "Андрей", 100);
        Player victor = new Player(2, "Виктор", 180);
        Game game = new Game();

        game.register(andrey);
        game.register(victor);
        int actual = game.round("Андрей", "Виктор");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenNoWinner() {
        Player andrey = new Player(1, "Андрей", 100);
        Player victor = new Player(2, "Виктор", 100);
        Game game = new Game();

        game.register(andrey);
        game.register(victor);
        int actual = game.round("Андрей", "Виктор");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenWrongFirstPlayer() {
        Player andrey = new Player(1, "Андрей", 100);
        Player victor = new Player(2, "Виктор", 80);
        Game game = new Game();

        game.register(andrey);
        game.register(victor);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Михаил", "Виктор")
        );
    }

    @Test
    public void WhenWrongSecondPlayer() {
        Player andrey = new Player(1, "Андрей", 100);
        Player victor = new Player(2, "Виктор", 80);
        Game game = new Game();

        game.register(andrey);
        game.register(victor);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Андрей", "Денис")
        );
    }
}
