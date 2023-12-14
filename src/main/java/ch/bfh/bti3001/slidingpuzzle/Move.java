/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package ch.bfh.bti3001.slidingpuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	private static final Random random = new Random();
	private static final Move[] allMoves = values();

	/**
	 * Returns the move that reverses the given move, for example {@code UP} reverses
	 * {@code DOWN}, etc.
	 *
	 * @return The reversed move
	 */
	public Move reverse() {
		return switch (this) {
			case UP -> DOWN;
			case DOWN -> UP;
			case LEFT -> RIGHT;
			case RIGHT -> LEFT;
		};
	}

	/**
	 * Returns the list of moves that reverses a given list of moves, for example
	 * {@code [UP, UP, LEFT]} reverses {@code [RIGHT, DOWN, DOWN]}, etc.
	 *
	 * @param moves The given list of moves
	 * @return The reversed list of moves
	 */
	public static List<Move> reverseMoves(List<Move> moves) {
		List<Move> reverseMoves = new ArrayList<>();
		for (int i = moves.size() - 1; i >= 0; i--) {
			reverseMoves.add(moves.get(i).reverse());
		}
		return reverseMoves;
	}

	/**
	 * Returns a random move.
	 *
	 * @return A random move
	 */
	public static Move getRandomMove() {
		return allMoves[random.nextInt(4)];
	}

}
