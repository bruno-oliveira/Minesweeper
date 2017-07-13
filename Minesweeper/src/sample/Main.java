package sample;

import gameLogic.GameBoard;
import gameLogic.StackedGameCell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane(); //Parent (instead of Pane) only allows to get an unmodifiable list
        primaryStage.setTitle("Minesweeper");

        StackedGameCell[][] gameBoard = new StackedGameCell[8][8];
        GameBoard boardClass = new GameBoard(gameBoard, root);
        boardClass.setupGameBoard();
        root = boardClass.getPane();
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
