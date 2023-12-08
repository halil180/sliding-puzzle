package ch.bfh.bti3001.slidingpuzzle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlidingPuzzleTest {

    @Test
    void testConstructor() {
        generatePuzzles().forEach(puzzle -> {
            assertEquals(puzzle.getWidth(), puzzle.getEmptyCol());
            assertEquals(puzzle.getHeight(), puzzle.getEmptyRow());
            assertTrue(puzzle.isEmpty(puzzle.getWidth(), puzzle.getHeight()));
            for (int col = 1; col <= puzzle.getWidth(); col++) {
                for (int row = 1; row <= puzzle.getHeight(); row++) {
                    if (!puzzle.isEmpty(col, row)) {
                        assertFalse(puzzle.isEmpty(col, row));
                        int value = col + (row - 1) * puzzle.getWidth();
                        assertEquals(value, puzzle.getValue(col, row));
                    }
                }
            }
        });
    }

    @Test
    void testCopyConstructor() {
        generatePuzzles().forEach(puzzle1 -> {
            Puzzle puzzle2 = new Puzzle(puzzle1);
            assertEquals(puzzle1, puzzle2);
            assertNotSame(puzzle1, puzzle2);
        });
    }

    @Test
    void testGetWidthHeight() {
        int n = 10;
        for (int width = 1; width <= n; width++) {
            for (int height = 1; height <= n; height++) {
                Puzzle puzzle = new Puzzle(width, height);
                assertEquals(width, puzzle.getWidth());
                assertEquals(height, puzzle.getHeight());
            }
        }
    }

    @Test
    void testIsSolved() {
        generatePuzzles().forEach(puzzle -> {
            assertTrue(puzzle.isSolved());
            if (puzzle.getWidth() > 1 || puzzle.getHeight() > 1) {
                puzzle.playRandomMove();
                assertFalse(puzzle.isSolved());
            }
        });
        generateShuffledPuzzles().forEach(puzzle -> {
            if (puzzle.getEmptyCol() != puzzle.getWidth() || puzzle.getEmptyRow() != puzzle.getHeight()) {
                assertFalse(puzzle.isSolved());
            }
        });
    }

    @Test
    void testIsValid() {
        generateShuffledPuzzles().forEach(puzzle -> {
            long count = Arrays.stream(Move.values()).filter(puzzle::isValid).count();
            if (puzzle.getEmptyCol() > 1) count--;
            if (puzzle.getEmptyCol() < puzzle.getWidth()) count--;
            if (puzzle.getEmptyRow() > 1) count--;
            if (puzzle.getEmptyRow() < puzzle.getHeight()) count--;
            assertEquals(0, count);
        });
    }

    @Test
    void testPlayRandomMove() {
        generateShuffledPuzzles().forEach(puzzle -> {
            Puzzle copy = new Puzzle(puzzle);
            Move move = puzzle.playRandomMove();
            assertNotEquals(copy, puzzle);
            copy.play(move);
            assertEquals(copy, puzzle);
            assertNotSame(copy, puzzle);
            move = puzzle.playRandomMove();
            assertNotEquals(copy, puzzle);
            puzzle.play(move.reverse());
            assertEquals(copy, puzzle);
            assertNotSame(copy, puzzle);
        });
    }

    @Test
    void testPlayRandomMoves() {
        generateShuffledPuzzles().forEach(puzzle -> {
            Puzzle copy = new Puzzle(puzzle);
            List<Move> moves = puzzle.playRandomMoves(10);
            copy.play(moves);
            assertEquals(copy, puzzle);
            assertNotSame(copy, puzzle);
            moves = puzzle.playRandomMoves(10);
            puzzle.play(Move.reverseMoves(moves));
            assertEquals(copy, puzzle);
            assertNotSame(copy, puzzle);
        });
    }


    @Test
    void testToString() {
        String string_1_2 = "+--+\n| 1|\n+--+\n|  |\n+--+\n";
        String string_1_5 = "+--+\n| 1|\n+--+\n| 2|\n+--+\n| 3|\n+--+\n| 4|\n+--+\n|  |\n+--+\n";
        String string_4_1 = "+--+--+--+--+\n| 1| 2| 3|  |\n+--+--+--+--+\n";
        String string_4_5 = """
                +--+--+--+--+
                | 1| 2| 3| 4|
                +--+--+--+--+
                | 5| 6| 7| 8|
                +--+--+--+--+
                | 9|10|11|12|
                +--+--+--+--+
                |13|14|15|16|
                +--+--+--+--+
                |17|18|19|  |
                +--+--+--+--+
                """;
        assertEquals(string_1_2, new Puzzle(1, 2).toString());
        assertEquals(string_1_5, new Puzzle(1, 5).toString());
        assertEquals(string_4_1, new Puzzle(4, 1).toString());
        assertEquals(string_4_5, new Puzzle(4, 5).toString());
    }

    private static List<Puzzle> generatePuzzles() {
        int n = 10;
        List<Puzzle> puzzles = new ArrayList<>();
        for (int width = 1; width <= n; width++) {
            for (int height = 1; height <= n; height++) {
                if (width > 0 || height > 0) {
                    puzzles.add(new Puzzle(width, height));
                }
            }
        }
        return puzzles;
    }

    private static List<Puzzle> generateShuffledPuzzles() {
        int n = 10;
        List<Puzzle> puzzles = new ArrayList<>();
        for (int width = 1; width <= n; width++) {
            for (int height = 1; height <= n; height++) {
                for (int i = 1; i <= width * height - 1; i++) {
                    Puzzle puzzle = new Puzzle(width, height);
                    puzzle.playRandomMoves(width * height);
                    puzzles.add(puzzle);
                }
            }
        }
        return puzzles;
    }

}