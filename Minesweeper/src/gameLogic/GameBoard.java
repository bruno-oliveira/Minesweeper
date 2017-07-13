package gameLogic;


import gameUtils.CellPosition;
import generators.BombPositionGenerator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class GameBoard {

    private final Pane root;
    protected int counterForGameState = 0;
    private StackedGameCell[][] gameBoard;

    public GameBoard(StackedGameCell[][] board, Pane root) {
        this.gameBoard = board;
        this.root = root;
    }

    public void setupGameBoard() {
        int[] bombs = BombPositionGenerator.getRandomFrom64();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = new StackedGameCell(this, new GameCell(400 / 8 * i, 400 / 8 * j), new Text(""));
                //gameBoard[i][j].setGameCell(new GameCell(400 / 8 * i, 400 / 8 * j));
            }
        }
        for (int bomb : bombs) {
            int xPos = bomb % 8 - 1;
            int yPos = bomb / 8;
            gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].getGameCell().setContainsMine(true);
            gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].getGameCell().setFill(Color.RED);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                neighbourBombsOf(i, j);
                int indicator = gameBoard[i][j].getGameCell().getIndicator();
                gameBoard[i][j].setCellText(new Text((indicator > 0 ? indicator : "") + ""));

                StackPane pane = new StackPane(gameBoard[i][j].getGameCell(), gameBoard[i][j].getCellText());
                pane.setLayoutX(gameBoard[i][j].getGameCell().getLayoutX());
                pane.setLayoutY(gameBoard[i][j].getGameCell().getLayoutY());

                gameBoard[i][j].setStackedCell(pane);

                root.getChildren().add(pane);
                // gameBoard[i][j] = new GameCell(400 / 8 * i, 400 / 8 * j);
            }
        }
    }

    private GameCell getCellInPoz(int i, int j) {
        return this.gameBoard[i][j].getGameCell();
    }

    void neighbourBombsOf(int i, int j) {
        List<CellPosition> listOfNeighbours = getCellInPoz(i, j).getNeighbours();
        int totalBombs = 0;
        for (CellPosition listOfNeighbour : listOfNeighbours) {
            int i_of_neighb = listOfNeighbour.getI();
            int j_of_neighb = listOfNeighbour.getJ();
            if (getCellInPoz(i_of_neighb, j_of_neighb).isContainsMine()) {
                totalBombs++;
            }
        }
        gameBoard[i][j].cellTextVisible(false);
        getCellInPoz(i, j).setIndicator(totalBombs);
        // return totalBombs;
    }

    public Pane getPane() {
        return root;
    }
}
