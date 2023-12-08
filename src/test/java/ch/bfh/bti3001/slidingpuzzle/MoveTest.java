package ch.bfh.bti3001.slidingpuzzle;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void testReverse() {
        for(Move move : Move.values()) {
            assertEquals(move, move.reverse().reverse());
        }
    }

    @Test
    void testStaticReverse() {
        int n = 100;
        List<Move> moves = Stream.generate(Move::getRandomMove).limit(n).toList();
        List<Move> reversedMoves = Move.reverseMoves(moves);
        for (int i = 0; i < n; i++) {
            assertEquals(moves.get(n - i - 1).reverse(), reversedMoves.get(i));
        }
    }

    @Test
    // statistical test to see if each value is selected between 0.8*n/s and 1.2*n/s times
    void getStaticRandomMove() {
        int n = 10000;
        int s = Move.values().length;
        List<Move> moves = Stream.generate(Move::getRandomMove).limit(n).toList();
        for(Move move : Move.values()) {
            long count = moves.stream().filter(other -> move == other).count();
            assertTrue(count > 0.8 * n / s);
            assertTrue(count < 1.2 * n / s);
        }
    }

}