package ch.bfh.bti3001.slidingpuzzle;

import ch.bfh.bti3001.slidingpuzzle.gui.Sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * This is the main class for running the sliding puzzle game as a JavaFX application. It can be launched by calling
 * then {@link JavaFXApp#main(String[])} method.
 */
public class JavaFXApp extends Application {

    @Override
    public void start(Stage stage) {
        // PuzzleBoard
        Parent root = createGridPane();

        // alignment elements
        VBox background = createVbox();
        HBox controlsBox = createHbox();

        VBox labelBox = createVbox();
        labelBox.setPadding(new Insets(20.0));
        labelBox.setAlignment(Pos.CENTER_LEFT);

        // control buttons
        Button newGameButton = new Button("New Game");
        Button resetButton = new Button("Reset Game");
        Button backButton = new Button("Back");

        // labels
        Label moves = new Label("Moves: ");
        Label message = new Label("CONGRATULATIONS!");
        message.getStyleClass().add("success");

        // assembling
        controlsBox.getChildren().addAll(List.of(newGameButton, resetButton, backButton));
        labelBox.getChildren().addAll(List.of(moves, message));
        background.getChildren().addAll(List.of(root, controlsBox, labelBox));

        // styling
        String stylesheet = String.valueOf(this.getClass().getResource("/styles.css"));

        // Scene
        Scene scene = new Scene(background);
        scene.getStylesheets().add(stylesheet);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Sliding Puzzle");
        stage.show();
    }

    private GridPane createGridPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(2.0));
        pane.setHgap(2.0);
        pane.setVgap(2.0);
        pane.getStyleClass().add("grid-pane");

        //TODO: change with actual implementation
        Sample.getButtons().forEach(button -> pane.add(
                        button,
                        button.getY(),
                        button.getX()
                )
        );
        return pane;
    }

    private VBox createVbox() {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(50.0));
        box.setSpacing(10.0);
        return box;
    }

    private HBox createHbox() {
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10.0);
        box.setPadding(new Insets(10.0));
        return box;
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
