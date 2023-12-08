package ch.bfh.bti3001.slidingpuzzle;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the main class for running the sliding puzzle game as a JavaFX application. It can be launched by calling
 * then {@link JavaFXApp#main(String[])} method.
 */
public class JavaFXApp extends Application {

    @Override
    public void start(Stage stage) {

        // TODO: WRITE YOUR CODE HERE

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
