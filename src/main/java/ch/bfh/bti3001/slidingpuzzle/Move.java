package ch.bfh.bti3001.slidingpuzzle;

import java.util.List;

/**
 * The four instances {@code UP}, {@code DOWN}, {@code LEFT}, and {@code UP} of this enum class
 * represent the four possible game moves.
 */
public enum Move {

    /**
     * Represents the move 'up'.
     */
    UP,
    /**
     * Represents the move 'down'.
     */
    DOWN,
    /**
     * Represents the move 'left'.
     */
    LEFT,
    /**
     * Represents the move 'right'.
     */
    RIGHT;

    /**
     * Returns the move that reverses the given move, for example {@code UP} reverses
     * {@code DOWN}, etc.
     *
     * @return The reversed move
     */
    public Move reverse() {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    /**
     * Returns the list of moves that reverses a given list of moves, for example
     * {@code [UP, UP, LEFT]} reverses {@code [RIGHT, DOWN, DOWN]}, etc.
     *
     * @param moves The given list of moves
     * @return The reversed list of moves
     */
    public static List<Move> reverseMoves(List<Move> moves) {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    /**
     * Returns a random move.
     *
     * @return A random move
     */
    public static Move getRandomMove() {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

}
