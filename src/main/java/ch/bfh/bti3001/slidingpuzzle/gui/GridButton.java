package ch.bfh.bti3001.slidingpuzzle.gui;

import javafx.scene.control.Button;

/**
 * @author : Igor Santana
 */
public class GridButton extends Button {
    private int x;
    private int y;

    public GridButton(String value, int x, int y) {
        super(value);
        this.x = x;
        this.y = y;

        setSize();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void setSize() {
        this.setMinWidth(70);
        this.setMinHeight(70);
    }
}
