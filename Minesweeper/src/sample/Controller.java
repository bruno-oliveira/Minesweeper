package sample;

import gameLogic.GameCell;

class Controller {
    private GameCell[][] gameBoard;

    Controller(GameCell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    GameCell[][] getGameBoard() {
        return gameBoard;
    }

    void setGameBoard(GameCell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
