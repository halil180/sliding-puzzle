/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package ch.bfh.bti3001.slidingpuzzle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Instances of this class represent a sliding puzzle of size {@code width * height}. It keeps track of the current
 * state of the puzzle when moves are being played.
 */
public class Puzzle {
    private static final String NEW_LN = System.lineSeparator();
    private static final String ROW_SEPARATOR = "--+";

    // [row][col]
    private final Integer[][] grid;
    private final int width;
    private final int height;
    private int emptyCellRow;
    private int emptyCellCol;

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
        this.width = width;
        this.height = height;
        emptyCellRow = height - 1;
        emptyCellCol = width - 1;

        grid = new Integer[height][width];

        int counter = 1;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = counter++;
            }
        }

        grid[emptyCellRow][emptyCellCol] = null;
    }

    /**
     * Creates a sliding puzzle by copying the state of a given {@link Puzzle} instance. This copy constructor is mainly
     * needed for testing purposes.
     *
     * @param puzzle The given {@link Puzzle} instance
     */
    public Puzzle(Puzzle puzzle) {
        this.grid = puzzle.grid;
        this.width = puzzle.width;
        this.height = puzzle.height;
        this.emptyCellRow = puzzle.emptyCellRow;
        this.emptyCellCol = puzzle.emptyCellCol;
    }

    /**
     * Returns the width of this sliding puzzle.
     *
     * @return The width of the sliding puzzle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this sliding puzzle.
     *
     * @return The height of the sliding puzzle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the column index of the empty cell. The columns are indexed from 1 to {@code width}.
     *
     * @return The column index of the empty cell
     */
    public int getEmptyCol() {
        return emptyCellCol + 1;
    }

    /**
     * Returns the row index of the empty cell. The rows are indexed from 1 to {@code height}.
     *
     * @return The row index of the empty cell
     */
    public int getEmptyRow() {
        return emptyCellRow + 1;
    }

    /**
     * Checks if all cells of the puzzle have the right value, i.e., if they are numbered from 1 to
     * {@code width * height - 1} from top left to bottom right, with the empty cell at the bottom of the rightmost
     * column.
     *
     * @return {@code true}, if the puzzle is solved, {@code false} otherwise
     */
    public boolean isSolved() {
        if (grid[height - 1][width - 1] != null) {
            return false;
        }

        int previous = 0;

        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++) {
                Integer current = grid[row][col];
                if (current == null) {
                    return true;
                } else if (current != previous + 1) {
                    return false;
                }
                previous++;
            }
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
        return col - 1 == emptyCellCol && row - 1 == emptyCellRow;
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
        return switch (move) {
            case UP -> emptyCellRow != height - 1;
            case DOWN -> emptyCellRow != 0;
            case LEFT -> emptyCellCol != width - 1;
            case RIGHT -> emptyCellCol != 0;
        };
    }

    /**
     * Plays a given move for the current state of the sliding puzzle, provided that the move is valid. Invalid moves
     * are ignored.
     *
     * @param move The given move
     */
    public void play(Move move) {
        if (!isValid(move)) {
            return;
        }

        int oldEmptyRow = emptyCellRow;
        int oldEmptyCol = emptyCellCol;

        switch (move) {
            case UP -> emptyCellRow++;
            case DOWN -> emptyCellRow--;
            case LEFT -> emptyCellCol++;
            case RIGHT -> emptyCellCol--;
        }

        grid[oldEmptyRow][oldEmptyCol] = grid[emptyCellRow][emptyCellCol];
        grid[emptyCellRow][emptyCellCol] = null;
    }

    /**
     * Plays a given list of moves in the specified order for the current state of the sliding puzzle, provided that the
     * moves are valid. Invalid moves are ignored.
     *
     * @param moves The given list of moves
     */
    public void play(List<Move> moves) {
        moves.forEach(this::play);
    }

    /**
     * Selects a random valid move and plays it. The played move is returned.
     *
     * @return The random move played
     */
    public Move playRandomMove() {
        boolean isValid = false;
        Move move = null;

        while (!isValid) {
            move = Move.getRandomMove();
            isValid = isValid(move);
        }

        play(move);
        return move;
    }

    /**
     * Selects multiple random valid move and plays them. The list of all played moves is returned.
     *
     * @param n The number of valid random moves to play.
     * @return The list of random moves played
     */
    public List<Move> playRandomMoves(int n) {
        return IntStream.range(0, n).mapToObj(x -> playRandomMove()).toList();
    }

    /**
     * Returns the value of the sliding puzzle at the cell specified by a column and row index. Columns and rows are
     * indexed from 1 to * {@code width} and {@code height}, respectively. For the empty cell, some special value is
     * returned.
     *
     * @param col The given column index
     * @param row The given row index
     * @return The value at the specified cell
     */
    public int getValue(int col, int row) {
        return grid[row - 1][col - 1];
    }

    @Override
    public String toString() {
        String rowLine = "+" + ROW_SEPARATOR.repeat(width) + NEW_LN;

        StringBuilder sb = new StringBuilder(rowLine);

        for (int row = 0; row < height; row++) {

            sb.append("|");

            for (int col = 0; col < width; col++) {
                Integer n = grid[row][col];
                sb.append(String.format("%2s|", n != null ? n : ""));
            }
            sb.append(NEW_LN).append(rowLine);
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Puzzle otherPuzzle = (Puzzle) obj;
        return this.width == otherPuzzle.width &&
                this.height == otherPuzzle.height &&
                this.emptyCellRow == otherPuzzle.emptyCellRow &&
                this.emptyCellCol == otherPuzzle.emptyCellCol &&
                Arrays.deepEquals(this.grid, otherPuzzle.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, emptyCellRow, emptyCellCol, Arrays.deepHashCode(grid));
    }

}
