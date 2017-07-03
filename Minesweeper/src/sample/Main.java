package sample;

import gameLogic.GameCell;
import generators.BombPositionGenerator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane(); //Parent (instead of Pane) only allows to get an unmodifiable list
        primaryStage.setTitle("Minesweeper");
        int[] bombs = BombPositionGenerator.getRandomFrom64();
        GameCell[][] gameBoard = new GameCell[8][8];
        Controller gameManager = new Controller(gameBoard);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = new GameCell(400 / 8 * i, 400 / 8 * j);
            }
        }
        for (int bomb : bombs) {
            int xPos = bomb % 8 - 1;
            int yPos = bomb / 8;
            gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].setContainsMine(true);
            gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].setFill(Color.RED);
        }

        gameManager.setGameBoard(gameBoard);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                root.getChildren().add(gameManager.getGameBoard()[i][j]);
                // gameBoard[i][j] = new GameCell(400 / 8 * i, 400 / 8 * j);
            }
        }

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
