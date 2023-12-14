/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package ch.bfh.bti3001.slidingpuzzle;

import java.util.List;

/**
 * Instances of this class represent a sliding puzzle of size {@code width * height}. It keeps track of the current
 * state of the puzzle when moves are being played.
 */
public class Puzzle {

    /**
     * Creates a new sliding puzzle for given size parameters {@code width} and {@code height}. It can be thought as a
     * 2-dimensional grid consisting of cells with values from 1 to {@code width * height - 1}, with one empty cell.
     * Initially, the puzzle is solved, i.e., all cells are numbered from 1 to * {@code width * height - 1} from top
     * left to bottom right, with the empty cell at the bottom of the rightmost column.
     *
     * @param width  The width of the sliding puzzle
     * @param height The height of the sliding puzzle
     */
    public Puzzle(int width, int height) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Creates a sliding puzzle by copying the state of a given {@link Puzzle} instance. This copy constructor is mainly
     * needed for testing purposes.
     *
     * @param puzzle The given {@link Puzzle} instance
     */
    public Puzzle(Puzzle puzzle) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Returns the width of this sliding puzzle.
     *
     * @return The width of the sliding puzzle
     */
    public int getWidth() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Returns the height of this sliding puzzle.
     *
     * @return The height of the sliding puzzle
     */
    public int getHeight() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Returns the column index of the empty cell. The columns are indexed from 1 to {@code width}.
     *
     * @return The column index of the empty cell
     */
    public int getEmptyCol() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Returns the row index of the empty cell. The rows are indexed from 1 to {@code height}.
     *
     * @return The row index of the empty cell
     */
    public int getEmptyRow() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

    /**
     * Checks if all cells of the puzzle have the right value, i.e., if they are numbered from 1 to
     * {@code width * height - 1} from top left to bottom right, with the empty cell at the bottom of the rightmost
     * column.
     *
     * @return {@code true}, if the puzzle is solved, {@code false} otherwise
     */
    public boolean isSolved() {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Checks if a cell given by a column and row index is the empty cell. Columns and rows are indexed from 1 to
     * {@code width} and {@code height}, respectively.
     *
     * @param col The given column index
     * @param row The given rew index
     * @return {@code true}, if the specified cell is empty, {@code false} otherwise
     */
    public boolean isEmpty(int col, int row) {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Checks if a given move is valid for the current state of the sliding puzzle. A valid move means that it can
     * actually be played. If the empty cell is not in a border column or row, then all moves are valid. Otherwise, if
     * the empty cell is in a border column or row, then corresponding moves are invalid.
     *
     * @param move The given move
     * @return {@code true}, if the given move is valid, {@code false} otherwise
     */
    public boolean isValid(Move move) {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    /**
     * Plays a given move for the current state of the sliding puzzle, provided that the move is valid. Invalid moves
     * are ignored.
     *
     * @param move The given move
     */
    public void play(Move move) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Plays a given list of moves in the specified order for the current state of the sliding puzzle, provided that the
     * moves are valid. Invalid moves are ignored.
     *
     * @param moves The given list of moves
     */
    public void play(List<Move> moves) {
        // TODO: WRITE YOUR CODE HERE
    }

    /**
     * Selects a random valid move and plays it. The played move is returned.
     *
     * @return The random move played
     */
    public Move playRandomMove() {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    /**
     * Selects multiple random valid move and plays them. The list of all played moves is returned.
     *
     * @param n The number of valid random moves to play.
     * @return The list of random moves played
     */
    public List<Move> playRandomMoves(int n) {
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

    @Override
    public String toString() {
        // TODO: WRITE YOUR CODE HERE
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: WRITE YOUR CODE HERE
        return true;
    }

    @Override
    public int hashCode() {
        // TODO: WRITE YOUR CODE HERE
        return 0;
    }

}