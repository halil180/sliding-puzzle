package ch.bfh.bti3001.slidingpuzzle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameTest {

    @Test
    void testConstructor() {
        for (int n = 2; n <= 10; n++) {
            for (int i = 1; i <= 10; i++) {
                Game game = new Game(n, n);
                assertFalse(game.gameOver());
                assertEquals(0, game.getTotalMoves());
                assertFalse(game.hasMoveBack());
            }
        }
    }

    @Test
    void testResetGame() {
        Game game = new Game(10, 10);
        Puzzle initialPuzzle = game.getCurrentPuzzle();
        int n = 1000;
        for (int i = 1; i <= n; i++) {
            game.play(Move.getRandomMove());
        }
        game.resetGame();
        assertEquals(initialPuzzle, game.getCurrentPuzzle());
    }

    @Test
    void testNewGame() {
        Game game = new Game(10, 10);
        Puzzle initialPuzzle = game.getCurrentPuzzle();
        int n = 1000;
        for (int i = 1; i <= n; i++) {
            game.play(Move.getRandomMove());
        }
        game.startNewGame(10, 10);
        assertNotEquals(initialPuzzle, game.getCurrentPuzzle()); // very low chance
    }

    @Test
    void testMove() {
        Game game = new Game(10, 10);
        int n = 1000;
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (game.play(Move.getRandomMove())) {
                counter++;
            }
        }
        assertEquals(counter, game.getTotalMoves());
    }

    @Test
    void testMoveBack() {
        Game game = new Game(10, 10);
        int n = 1000;
        Puzzle initialPuzzle = game.getCurrentPuzzle();
        for (int i = 1; i <= n; i++) {
            game.play(Move.getRandomMove());
        }
        int totalMoves = game.getTotalMoves();
        // do nothing
        while (game.hasMoveBack()) {
            game.moveBack();
        }
        assertEquals(initialPuzzle, game.getCurrentPuzzle());
        assertEquals(2 * totalMoves, game.getTotalMoves());
    }

}