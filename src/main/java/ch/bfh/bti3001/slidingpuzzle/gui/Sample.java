package ch.bfh.bti3001.slidingpuzzle.gui;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Initial sample playground.
 *
 * @author : Igor Santana
 */
public class Sample {

    /**
     * For testing purposes.
     * Returns a list of {@code GridButton} elements, where odd-indexed buttons have
     * the style classes "grid-button" and "odd-indexed," even-indexed buttons have
     * the style class "grid-button," and the last button has the style class
     * "empty-cell."
     * @return A list of {@code GridButton} elements with applied style classes.
     *
     */
    public static List<GridButton> getButtons() {
        final List<GridButton> oddIndexed = IntStream.range(0, BUTTONS.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(BUTTONS::get)
                .toList();

        final List<GridButton> evenIndexed = IntStream.range(0, BUTTONS.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(BUTTONS::get)
                .toList();

        oddIndexed.forEach(button -> button.getStyleClass().addAll("grid-button", "odd-indexed"));
        evenIndexed.forEach(button -> button.getStyleClass().add("grid-button"));
        List<GridButton> buttons = Stream.concat(oddIndexed.stream(), evenIndexed.stream()).toList();
        GridButton element = buttons.get(buttons.size() - 1);
        element.getStyleClass().add("empty-cell");

        return buttons;
    }

    /**
     * Sample Puzzle: must be replaced with actual puzzle of the game.
     */
    private static final List<GridButton> BUTTONS = List.of(
            new GridButton("1", 0, 0),
            new GridButton("2", 0, 1),
            new GridButton("3", 0, 2),
            new GridButton("4", 0, 3),
            new GridButton("5", 1, 0),
            new GridButton("6", 1, 1),
            new GridButton("7", 1, 2),
            new GridButton("8", 1, 3),
            new GridButton("9", 2, 0),
            new GridButton("10", 2, 1),
            new GridButton("11", 2, 2),
            new GridButton("12", 2, 3),
            new GridButton("13", 3, 0),
            new GridButton("14", 3, 1),
            new GridButton("15", 3, 2),
            new GridButton("", 3, 3)
    );
}
