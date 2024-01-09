package ch.bfh.bti3001.slidingpuzzle.gui;

import ch.bfh.bti3001.slidingpuzzle.Game;
import ch.bfh.bti3001.slidingpuzzle.Move;
import ch.bfh.bti3001.slidingpuzzle.Puzzle;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Optional;

/**
 * @author : Igor Santana
 */
public class PuzzleViewController {
    private static final String TOTAL_MOVES = "Moves: ";

    private final PuzzleView puzzleView;
    private final Game game;

    public PuzzleViewController(final Game game, PuzzleView puzzleView) {
        this.game = game;
        this.puzzleView = puzzleView;
        puzzleView.setController(this);
        updateFields();
        setPuzzleGrid();
    }

    public void slide(final int column, final int row) {
        Optional<Move> optional = game.getMove(column, row);
        optional.ifPresent(mv -> {
            game.play(mv);
            updateFields();
        });
    }

    public VBox getBackground() {
        return puzzleView.background;
    }

    public void newGame() {
        game.startNewGame(4, 4);

        resetProperties();
        updateFields();
    }

    public void resetGame() {
        game.resetGame();
        updateFields();
    }

    public void moveBack() {
        game.moveBack();
        updateFields();
    }

    private void resetProperties() {
        puzzleView.message.setVisible(false);
        puzzleView.resetButton.setDisable(false);
        puzzleView.backButton.setDisable(false);
    }

    private void updateFields() {
        puzzleView.totalMoves.setText(TOTAL_MOVES + game.getTotalMoves());
        setPuzzleGrid();

        if (game.gameOver()) {
            puzzleView.message.setVisible(true);
            puzzleView.resetButton.setDisable(true);
            puzzleView.backButton.setDisable(true);
            puzzleView.gridPane.getChildren().forEach(button -> button.setOnMouseClicked(null));
        }
    }

    private void setPuzzleGrid() {
        Puzzle puzzle = game.getCurrentPuzzle();
        for (int row = 0; row < puzzle.getHeight(); row++) {
            for (int column = 0; column < puzzle.getWidth(); column++) {
                // puzzle is indexed from 1 to height * width - 1
                String text = String.valueOf(game.getValue(column + 1, row + 1));
                Button button = puzzleView.createGridButton(text, column + 1, row + 1);

                if (column % 2 == 0) button.getStyleClass().add("pink-cell");
                if (puzzle.isEmpty(column + 1, row + 1)) button.getStyleClass().add("empty-cell");

                GridPane.setConstraints(button, column, row);
                puzzleView.gridPane.getChildren().add(button);
            }
        }
    }
}
