/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package ch.bfh.bti3001.slidingpuzzle;

import java.util.Optional;

/**
 * Instances of this class represent a running sliding puzzle game. In addition to the sliding puzzle itself, it takes
 * track of all previously played moves to allow users to backtrack to previous game states. It also keeps track of the
 * total number of previously played moves, where backtracking moves are also counted. A new instance of this class
 * contains an unsolved puzzle.
 */
public class Game {

    /**
     * Construct a new instance of this class for specified {@code width} and {@code height} parameters. It ensures that
     * the sliding puzzle is not solved by coincidence.
     *
     * @param width  The width of the sliding puzzle
     * @param height The height of the sliding puzzle
     */
    public Game(int width, int height) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Return the total number of moves played since the beginning of the game.
     *
     * @return The total number of moves played
     */
    public int getTotalMoves() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Returns a copy of the current sliding puzzle instance. This method is mainly for testing purposes.
     *
     * @return A copy of the sliding puzzle instance.
     */
    public Puzzle getCurrentPuzzle() {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    /**
     * Starts a new game for specified {@code width} and {@code height} parameters. Everything is reset to the initial
     * state.
     *
     * @param width  The width of the new sliding puzzle
     * @param height The height of the new sliding puzzle
     */
    public void startNewGame(int width, int height) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Resets the current game to the initial state after its creation.
     */
    public void resetGame() {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Checks if the game is over. This is the case, if the sliding puzzle is solved.
     *
     * @return {@code true}, if the game is over, {@code false} otherwise
     */
    public boolean gameOver() {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Checks if a specified cell can be played in the current game, which is the case when the empty cell is a
     * neighboring cell. If this is the case, {@link Optional} containing the corresponding {@link Move} instance is
     * returned. Otherwise,  an empty {@link Optional} is returned. Columns and rows are indexed from 1 to *
     * {@code width} and {@code height}, respectively.
     *
     * @param col The given column index
     * @param row The given rew index
     * @return An {@link Optional} containing the corresponding {@link Move} instance (or an empty {@link Optional})
     */
    public Optional<Move> getMove(int col, int row) {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    /**
     * Returns the value of the sliding puzzle at the cell specified by a column and row index. Columns and rows are
     * indexed from 1 to * {@code width} and {@code height}, respectively. For the empty cell, some special value is
     * returned.
     *
     * @param col The given column index
     * @param row The given rew index
     * @return The value at the specified cell
     */
    public int getValue(int col, int row) {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Plays a given move for the current state of the sliding puzzle, provided that the move is valid. Invalid moves
     * are ignored. Returns {@code true} or {@code false}, depending on whether a move has been played.
     *
     * @param move The given move
     * @return {@code true}, if the move has been played, {@code false}, otherwise
     */
    public boolean play(Move move) {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Checks if the current game has moves that can be taken back.
     *
     * @return {@code true}, if the current game has moves that can be taken back, {@code false} otherwise
     */
    public boolean hasMoveBack() {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Backtracks the current game by one move, if such a move exists.
     */
    public void moveBack() {
        // TODO: WRITE YOUR CODE HERE
    }

}
