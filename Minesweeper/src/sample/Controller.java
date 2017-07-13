package sample;

import gameLogic.StackedGameCell;

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



    /*

     */


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
