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
}
