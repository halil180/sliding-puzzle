package ch.bfh.bti3001.slidingpuzzle.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * @author : Igor Santana
 */
public class PuzzleView {
    private PuzzleViewController controller;

    // layout
    GridPane gridPane;
    VBox background;
    HBox controlsBox;
    VBox labelBox;

    // control
    Button newGameButton;
    Button resetButton;
    Button backButton;

    // label
    Label title;
    Label totalMoves;
    Label message;

    public PuzzleView() {
        this.initializeNodes();
        this.layoutNodes();
        this.styleNodes();
        this.setNodeProperties();
    }

    public void setController(final PuzzleViewController controller) {
        this.controller = controller;
    }

    public Button createGridButton(final String text, final int column, final int row) {
        Button button = new Button(text);
        button.setOnMouseClicked(event -> controller.slide(column, row));

        button.getStyleClass().add("grid-button");
        button.setMinHeight(70);
        button.setMinWidth(70);

        return button;
    }

    private void initializeNodes() {
        gridPane = new GridPane();
        background = new VBox();
        labelBox = new VBox();
        controlsBox = new HBox();
        newGameButton = new Button("New Game");
        resetButton = new Button("Reset Game");
        backButton = new Button("Back");
        totalMoves = new Label("Moves: ");
        message = new Label("CONGRATULATIONS!");
        title = new Label("Sliding Puzzle");
    }

    private void layoutNodes() {
        background.setAlignment(Pos.CENTER);
        background.setPadding(new Insets(50.0));
        background.setSpacing(10.0);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(2.0);
        gridPane.setVgap(2.0);
        gridPane.setPadding(new Insets(2.0));

        controlsBox.setAlignment(Pos.CENTER);
        controlsBox.setSpacing(10.0);
        controlsBox.setPadding(new Insets(8.0));

        labelBox.setAlignment(Pos.CENTER_LEFT);
        labelBox.setPadding(new Insets(10.0));
        labelBox.setSpacing(10.0);
    }

    private void styleNodes() {
        gridPane.getStyleClass().add("grid-pane");
        message.getStyleClass().add("success");
        title.getStyleClass().add("label-title");
    }

    private void setNodeProperties() {
        message.setVisible(false);

        newGameButton.setOnMouseClicked(event -> controller.newGame());
        resetButton.setOnMouseClicked(event -> controller.resetGame());
        backButton.setOnMouseClicked(event -> controller.moveBack());

        controlsBox.getChildren().addAll(List.of(newGameButton, resetButton, backButton));
        labelBox.getChildren().addAll(List.of(totalMoves, message));
        background.getChildren().addAll(List.of(title, gridPane, controlsBox, labelBox));
    }
}
