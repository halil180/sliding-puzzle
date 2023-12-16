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
    private Puzzle puzzle;

    public PuzzleViewController(final Game game, PuzzleView puzzleView) {
        this.game = game;
        this.puzzleView = puzzleView;
        puzzleView.setController(this);
        puzzle = game.getCurrentPuzzle();
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

    public VBox getView() {
        return puzzleView.background;
    }

    public void newGame() {
        game.startNewGame(4, 4);
        puzzle = game.getCurrentPuzzle();

        resetFields();
        setPuzzleGrid();
    }

    public void resetGame() {
        game.resetGame();
        setPuzzleGrid();
    }

    public void moveBack() {
        game.moveBack();
        updateFields();
        setPuzzleGrid();
    }

    private void resetFields() {
        puzzleView.message.setVisible(false);
        puzzleView.resetButton.setDisable(false);
        puzzleView.backButton.setDisable(false);
        puzzleView.totalMoves.setText(TOTAL_MOVES + game.getTotalMoves());
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
        int width = puzzle.getWidth();
        int height = puzzle.getHeight();


        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                // puzzle is indexed from 1 to height * width -1
                int puzzleColumn = column + 1;
                int puzzleRow = row + 1;

                String text = String.valueOf(game.getValue(puzzleColumn, puzzleRow));
                Button button = puzzleView.createGridButton(text, puzzleColumn, puzzleRow);

                if (column % 2 == 0) {
                    button.getStyleClass().add("pink-cell");
                }
                if (puzzle.isEmpty(puzzleColumn, puzzleRow)) {
                    button.getStyleClass().add("empty-cell");
                }
                GridPane.setConstraints(button, column, row);
                puzzleView.gridPane.getChildren().add(button);
            }
        }
    }
}
