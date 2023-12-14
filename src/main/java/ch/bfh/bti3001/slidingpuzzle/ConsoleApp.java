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
        int width = 3;
        int height = 3;
        System.out.println("WELCOME TO THE SLIDING PUZZLE APP!!!");
        System.out.println("Commands: u=up, d=down, l=left, r=right, b=back, n=new, s=reset, q=quit");
        Game game = new Game(width,height);// new game instance 3*3
        Scanner scanner = new Scanner(System.in);

        ///while(true or some function()){
        System.out.println("Moves = " + game.getTotalMoves());
        game.getCurrentPuzzle();//TODO display this correctly
        char userInput = scanner.next().charAt(0);
        switch (userInput) {
            case 'u':
                System.out.println("You pressed UP");
                game.play(Move.UP);
                break;
            case 'd':
                System.out.println("DOWN");
                game.play(Move.DOWN);
                break;
            case 'l':
                System.out.println("LEFT");
                game.play(Move.LEFT);
                break;
            case 'r':
                System.out.println("RIGHT");
                game.play(Move.RIGHT);
                break;
            case 'b':
                System.out.println("BACK");
                if (game.hasMoveBack()){
                    game.moveBack();
                }else{
                    System.out.println("you don't have a move that can be taken back");
                }
                break;
            case 'n':
                System.out.println("NEW");
                game.startNewGame(height,width);
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
            System.out.println("CONGRATULATIONS!!! You solved the puzzle, Total Moves = " + game.getTotalMoves());
            // break;
        }


        // }

    }

}
