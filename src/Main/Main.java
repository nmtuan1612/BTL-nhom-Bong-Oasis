package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static Scene scene;
    public static Stage Stage;
    long lastCreatingTime = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws InterruptedException {
        stage.setTitle("Drawing Operations Test");
        GameField gameField = new GameField() ;
        GameScenes gameScenes = new GameScenes() ;
        gameScenes.setGameField(gameField);
        Stage = stage;
        Main.scene = gameScenes.GameMenu();
        Main.Stage.setScene(Main.scene);
       gameField.mouseEvent(stage);
        stage.show();
        System.out.println("kimochi");
    }
}

