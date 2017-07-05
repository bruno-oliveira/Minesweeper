package sample;

import gameLogic.GameCell;
import gameLogic.StackedGameCell;
import gameUtils.CellPosition;

import java.util.List;

class Controller {
    private StackedGameCell[][] gameBoard;

    Controller(StackedGameCell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    StackedGameCell[][] getGameBoard() {
        return gameBoard;
    }

    void setGameBoard(StackedGameCell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    GameCell getCellInPoz(int i, int j) {
        return this.gameBoard[i][j].getGameCell();
    }

    /*

     */
    void neighbourBombsOf(int i, int j) {
        List<CellPosition> listOfNeighbours = getCellInPoz(i, j).getNeighbours();
        int totalBombs = 0;
        for (int k = 0; k < listOfNeighbours.size(); k++) {
            int i_of_neighb = listOfNeighbours.get(k).getI();
            int j_of_neighb = listOfNeighbours.get(k).getJ();
            if (getCellInPoz(i_of_neighb, j_of_neighb).isContainsMine()) {
                totalBombs++;
            }
        }
        gameBoard[i][j].cellTextVisible(false);
        getCellInPoz(i, j).setIndicator(totalBombs);
        // return totalBombs;
    }
}
