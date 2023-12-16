/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package ch.bfh.bti3001.slidingpuzzle;

import ch.bfh.bti3001.slidingpuzzle.gui.PuzzleView;
import ch.bfh.bti3001.slidingpuzzle.gui.PuzzleViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class for running the sliding puzzle game as a JavaFX application. It can be launched by calling
 * then {@link JavaFXApp#main(String[])} method.
 */
public class JavaFXApp extends Application {

    @Override
    public void start(Stage stage) {
        int width = 4;
        int height = 4;
        Game game = new Game(width, height);
        PuzzleViewController controller = new PuzzleViewController(game, new PuzzleView());

        // styling
        String stylesheet = String.valueOf(this.getClass().getResource("/styles.css"));

        // Scene
        Scene scene = new Scene(controller.getView());
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Sliding Puzzle");
        stage.show();
    }

    /**
     * Launches the sliding puzzle game as a JavaFX application.
     *
     * @param args The list if application arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
