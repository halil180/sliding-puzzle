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

    public static void main(String[] args) {
        int width = 3;
        int height = 3;
        System.out.println("WELCOME TO THE SLIDING PUZZLE APP!!!");
        System.out.println("Commands: u=up, d=down, l=left, r=right, b=back, n=new, s=reset, q=quit");
        //TODO use Game instead of Puzzle when implemented :  Game game = new Game(width,height);// new game instance 3*3
        Puzzle puzzle = new Puzzle(width, height);// temporary solution, delete this line when Game class is ready
        puzzle.playRandomMoves(50);
        playGame(puzzle);
    }

    private static void playGame(Puzzle puzzle) {
        System.out.println(puzzle);
        System.out.println("moves = 0"); //TODO use game.getMoves() to get number of moves
        while (!puzzle.isSolved()) {
            readInput(puzzle);
            System.out.println(puzzle);
            System.out.println("moves = 0"); //TODO use game.getMoves() to get number of moves
        }
        System.out.println("Congratulations! Commands: n=new, q=quit");
        readInput(puzzle);
    }

    private static void readInput(Puzzle puzzle) {  //TODO readInput(Game game)
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        switch (input) {
            case UP -> {
                if (puzzle.isValid(Move.UP)) {
                    puzzle.play(Move.UP);
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
            case DOWN -> {
                if (puzzle.isValid(Move.DOWN)) {
                    puzzle.play(Move.DOWN);
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
            case LEFT -> {
                if (puzzle.isValid(Move.LEFT)) {
                    puzzle.play(Move.LEFT);
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
            case RIGHT -> {
                if (puzzle.isValid(Move.RIGHT)) {
                    puzzle.play(Move.RIGHT);
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            }
            case BACK, NEW, RESET -> {
                System.out.println("Command not implemented yet.");
            }
            case QUIT -> {
                System.out.println("BYE");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid command. Please try again.");
                readInput(puzzle);
            }
        }

    }

}
