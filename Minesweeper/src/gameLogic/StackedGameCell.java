package gameLogic;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * This will have to be changed later, but for now,
 * a stacked game cell is a StackPane composed of a game cell and text, placed in a stackPane.
 * Click events on game cells should be handled here.
 */
public class StackedGameCell {
    private StackPane stackedCell;
    private GameCell gameCell;
    private Text cellText;

    public StackedGameCell(GameCell gameCell, Text cellText) {
        this.gameCell = gameCell;
        this.cellText = cellText;
    }

    public Text getCellText() {
        return cellText;
    }

    public void setCellText(Text cellText) {
        this.cellText = cellText;
    }

    public GameCell getGameCell() {
        return gameCell;
    }

    public void setGameCell(GameCell gameCell) {
        this.gameCell = gameCell;
    }

    public StackPane getStackedCell() {
        return stackedCell;
    }

    public void setStackedCell(StackPane stackedCell) {
        this.stackedCell = stackedCell;
    }
}
