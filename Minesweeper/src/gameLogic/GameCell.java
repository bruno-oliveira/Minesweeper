package gameLogic;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class GameCell extends Rectangle implements Discoverable {
    private boolean containsMine;
    private int indicator;
    private int locationX;
    private int locationY;

    public GameCell(int locationX, int locationY) {
        super(400 / 8.0, 400 / 8.0, Color.LIGHTGREY);
        this.locationX = locationX;
        this.locationY = locationY;
        super.setLayoutX(locationX * 1.0);
        super.setLayoutY(locationY * 1.0);
        super.setStroke(Color.BLACK);
    }

    @Override
    public List<Node> getNeighbours() {
        return null;
    }

    public boolean isContainsMine() {
        return containsMine;
    }

    public void setContainsMine(boolean containsMine) {
        this.containsMine = containsMine;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }
}
