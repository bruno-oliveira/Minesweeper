package sample;

import gameLogic.GameCell;
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
        Pane root = new Pane(); //Parent only allows to get an unmodifiable list
        primaryStage.setTitle("Minesweeper");
        GameCell[][] gameBoard = new GameCell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = new GameCell(400 / 8 * i, 400 / 8 * j);
                root.getChildren().add(gameBoard[i][j]);
            }
        }

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
