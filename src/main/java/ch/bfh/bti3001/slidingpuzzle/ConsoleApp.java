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
    public static void main(String[] args) {

        System.out.println("WELCOME TO THE SLIDING PUZZLE APP!!!");
        System.out.println("Commands: u=up, d=down, l=left, r=right, b=back, n=new, s=reset, q=quit");
        Game game = new Game(3,3);// new game instance 3*3

        ///while(true or some function()){
        System.out.println("Moves = " + game.getTotalMoves());
        //TODO display the puzzle
        Scanner scanner = new Scanner(System.in);
        char userInput = scanner.next().charAt(0);
        switch (userInput) {
            case 'u':
                System.out.println("You pressed UP");
                ///do something......
                break;
            case 'd':
                System.out.println("DOWN");
                break;
            case 'l':
                System.out.println("LEFT");
                break;
            case 'r':
                System.out.println("RIGHT");
                break;
            case 'b':
                System.out.println("BACK");
                break;
            case 'n':
                System.out.println("NEW");
                game.startNewGame(3,3);
                break;
            case 's':
                System.out.println("RESET");
                game.resetGame();
                break;
            case 'q':
                System.out.println("BYE");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command. Please try again.");
                break;
        }


        if (game.gameOver()){
            System.out.println("CONGRATULATION");
            // break;
        }


        // }

    }

}
