package sample;

import gameLogic.GameCell;
import gameLogic.StackedGameCell;
import generators.BombPositionGenerator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
        StackedGameCell[][] gameBoard = new StackedGameCell[8][8];
        Controller gameManager = new Controller(gameBoard);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = new StackedGameCell(new GameCell(400 / 8 * i, 400 / 8 * j), new Text(""));
                //gameBoard[i][j].setGameCell(new GameCell(400 / 8 * i, 400 / 8 * j));
            }
        }
        for (int bomb : bombs) {
            int xPos = bomb % 8 - 1;
            int yPos = bomb / 8;
            gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].getGameCell().setContainsMine(true);
            //  gameBoard[xPos < 0 ? 8 - 1 : xPos][yPos].getGameCell().setFill(Color.RED);
        }

        gameManager.setGameBoard(gameBoard);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameManager.neighbourBombsOf(i, j);
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

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
