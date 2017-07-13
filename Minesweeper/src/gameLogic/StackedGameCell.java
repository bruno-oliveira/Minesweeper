package gameLogic;

import javafx.application.Platform;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    private boolean isClicked;

    public StackedGameCell(GameBoard gameBoard, GameCell gameCell, Text cellText) {
        this.gameCell = gameCell;
        this.cellText = cellText;
        gameCell.setOnMouseClicked((MouseEvent mouseEvent) -> {
            setClicked(true);
            if (!gameCell.isContainsMine()) {
                // updateCounter(gameBoard.counterForGameState);
                System.out.println("Counter is " + updateCounter(gameBoard, gameBoard.counterForGameState));
                gameCell.setOpacity(0.2);
                cellTextVisible(true);
                System.out.println("The number of neighbours is " + gameCell.getIndicator());
                checkWin(gameBoard);
                gameCell.setDisable(true); //can only click once in the same cell
            } else {
                gameCell.setFill(Color.RED);
                Pane gameOver = new Pane();
                Dialog<String> window = new Dialog<>();
                window.getDialogPane().getButtonTypes().add(new ButtonType("Quit", ButtonBar.ButtonData.CANCEL_CLOSE));
                window.setContentText("Game over");
                window.showAndWait();
                window.setOnShown(e -> {
                    window.setContentText("aaa");
                });
                Platform.exit();



            }

        });
    }

    private int updateCounter(GameBoard board, int counterForGameState) {
        board.counterForGameState++;
        return board.counterForGameState;
    }

    public void checkWin(GameBoard gameBoard) {
        int NBOMBS = 10;
        if (gameBoard.counterForGameState == 8 * 8 - NBOMBS) {
            Dialog<String> window = new Dialog<>();
            window.getDialogPane().getButtonTypes().add(new ButtonType("Quit", ButtonBar.ButtonData.CANCEL_CLOSE));
            window.setContentText("You won the game!!");
            window.showAndWait();
            window.setOnShown(e -> {
                window.setContentText("aaa");
            });
            Platform.exit();

        }
    }

    public void cellTextVisible(boolean visibility) {
        this.cellText.setVisible(visibility);

    }
    public Text getCellText() {
        return cellText;
    }

    public void setCellText(Text cellText) {
        this.cellText = cellText;
        this.cellText.setVisible(false);
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

    public boolean isClicked() {
        return isClicked;
    }

    private void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
