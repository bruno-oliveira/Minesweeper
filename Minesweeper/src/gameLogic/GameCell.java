package gameLogic;

import gameUtils.CellPosition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameCell extends Rectangle implements Discoverable {
    private boolean containsMine;
    private int indicator;
    private int locationX;
    private int locationY;

    GameCell(int locationX, int locationY) {
        super(400 / 8.0, 400 / 8.0, Color.LIGHTGREY);
        this.locationX = locationX;
        this.locationY = locationY;
        this.indicator = getNeighbours().size();
        super.setLayoutX(locationX * 1.0);
        super.setLayoutY(locationY * 1.0);
        super.setStroke(Color.BLACK);


    }

    @Override
    public List<CellPosition> getNeighbours() {
        int coordX = getLocationX() / (400 / 8);
        int coordY = getLocationY() / (400 / 8);
        //   System.out.println("X: " + coordX + " -- Y: " + coordY);
        List<Integer> xLeftToRightTopToBottom = new ArrayList<>(Arrays.asList(coordX - 1, coordX, coordX + 1,
                coordX - 1, coordX + 1, coordX - 1, coordX, coordX + 1));
        List<Integer> yLeftToRightTopToBottom = new ArrayList<>(Arrays.asList(coordY - 1, coordY - 1, coordY - 1,
                coordY, coordY, coordY + 1, coordY + 1, coordY + 1));

        List<CellPosition> validNeighbours = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (xLeftToRightTopToBottom.get(i) >= 0 && xLeftToRightTopToBottom.get(i) <= 7 && yLeftToRightTopToBottom.get(i) >= 0 && yLeftToRightTopToBottom.get(i) <= 7) {
                validNeighbours.add(new CellPosition(xLeftToRightTopToBottom.get(i), yLeftToRightTopToBottom.get(i)));
            }
        }
        System.out.println("Size is " + validNeighbours.size());
        return validNeighbours;
    }

    boolean isContainsMine() {
        return containsMine;
    }

    void setContainsMine(boolean containsMine) {
        this.containsMine = containsMine;
    }

    int getIndicator() {
        return indicator;
    }

    void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    private int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    private int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
}
