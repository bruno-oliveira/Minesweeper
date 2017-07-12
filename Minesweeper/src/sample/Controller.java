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

    private GameCell getCellInPoz(int i, int j) {
        return this.gameBoard[i][j].getGameCell();
    }

    /*

     */
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

    public void checkWin() {
        int count = 0;
        int NBOMBS = 10;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gameBoard[i][j].isClicked()) {
                    count++;
                    System.out.println("CURR COUNT IS " + count);
                    if (count == 8 * 8 - NBOMBS) {
                        System.out.println("GAME WON");
                    }
                }
            }
        }
        if (count == 8 * 8 - NBOMBS) {
            System.out.println("GAME WON");
        }
    }
}
