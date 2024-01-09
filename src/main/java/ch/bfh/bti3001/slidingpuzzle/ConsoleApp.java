/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */
package ch.bfh.bti3001.slidingpuzzle;

import java.util.Scanner;

/**
 * This is the main class for running the sliding puzzle game in the console. It can be launched by calling then
 * {@link ConsoleApp#main(String[])} method.
 */
public class ConsoleApp {
    /**
     * Launches the sliding puzzle game in the console.
     *
     * @param args The list if application arguments
     */
    private static final char UP = 'u';
    private static final char DOWN = 'd';
    private static final char LEFT = 'l';
    private static final char RIGHT = 'r';
    private static final char BACK = 'b';
    private static final char NEW = 'n';
    private static final char RESET = 's';
    private static final char QUIT = 'q';
    private static final int width = 3;
    private static final int height = 3;
    private static final String INVALID_MOVE_MESSAGE = "Invalid move. Please try again.";
    private static final String RESET_SUCCESS_MESSAGE = "\uD83D\uDD04 \uD83D\uDD04 Game reset successfully. \uD83D\uDD04 \uD83D\uDD04";
    private static final String CANNOT_MOVE_BACK_MESSAGE = "You cannot move back.";
    private static final String INVALID_COMMAND_MESSAGE = "Invalid command. Please try again.";
    private static final String GOODBYE_MESSAGE = "BYE \uD83D\uDC4B";
    private static final String NEW_GAME_MESSAGE = "new game \uD83C\uDF89\uD83D\uDE4C\uD83E\uDD73";
    public static final String PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String GREEN = "\033[0;32m";
    public static final String COLOR_RESET = "\033[0m";

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE SLIDING PUZZLE APP!!!");
        System.out.println("Commands: u=up, d=down, l=left, r=right, b=back, n=new, s=reset, q=quit");
        Game game = new Game(width, height);
        playGame(game);
    }

    private static void playGame(Game game) {
        System.out.println(ANSI_CYAN + game.getCurrentPuzzle() + COLOR_RESET);
        System.out.println(PURPLE + "moves = " + game.getTotalMoves() + COLOR_RESET);
        while (!game.gameOver()) {
            readInput(game);
            System.out.println(ANSI_CYAN + game.getCurrentPuzzle() + COLOR_RESET);
            System.out.println(PURPLE + "moves = " + game.getTotalMoves() + COLOR_RESET);
        }
        System.out.println(GREEN + "Congratulations! Commands: n=new, q=quit");
        readInput(game);
    }

    private static void readInput(Game game) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        switch (input) {
            case UP -> {
                if (game.play(Move.UP)) {
                    System.out.println("moving ⬆️");
                } else {
                    System.out.println(INVALID_MOVE_MESSAGE);
                }
            }
            case DOWN -> {
                if (game.play(Move.DOWN)) {
                    System.out.println("moving ⬇️");
                } else {
                    System.out.println(INVALID_MOVE_MESSAGE);
                }
            }
            case LEFT -> {
                if (game.play(Move.LEFT)) {
                    System.out.println("moving ⬅️");
                } else {
                    System.out.println(INVALID_MOVE_MESSAGE);
                }
            }
            case RIGHT -> {
                if (game.play(Move.RIGHT)) {
                    System.out.println("moving ➡️");
                } else {
                    System.out.println(INVALID_MOVE_MESSAGE);
                }
            }
            case NEW -> {
                System.out.println(NEW_GAME_MESSAGE);
                game.startNewGame(width, height);
                playGame(game);
            }
            case RESET -> {
                game.resetGame();
                System.out.println(RESET_SUCCESS_MESSAGE);
            }
            case BACK -> {
                if (game.hasMoveBack()) {
                    System.out.println("↩️");
                    game.moveBack();
                } else {
                    System.out.println(CANNOT_MOVE_BACK_MESSAGE);
                }
            }
            case QUIT -> {
                System.out.println(GOODBYE_MESSAGE);
                System.exit(0);
            }
            default -> {
                System.out.println(INVALID_COMMAND_MESSAGE);
                readInput(game);
            }
        }
    }
}