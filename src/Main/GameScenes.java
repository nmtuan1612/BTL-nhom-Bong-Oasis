package Main;
import GameObject.Sound;
import Main.Map.Map;
import Tower.Tower;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class GameScenes {
    //    public static String StartDefense = "off";
    Map map = new Map() ;
    GameField gameField;
    private Sound starGame = new Sound("audio\\music.mp3") ;
    private Sound game = new Sound("audio\\play.mp3") ;
    public  Scene GameMenu() {
        Canvas canvas = new Canvas(96 * 16, 96 * 10);
        map.gc = canvas.getGraphicsContext2D();
        gameField.gc = canvas.getGraphicsContext2D() ;
        Group root = new Group();
        root.getChildren().add(canvas);

        // Start button
        ImageView iv = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\StartButton.png"));
        Button startButton = new Button("", iv);
        startButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        startButton.setLayoutX(900);
        startButton.setLayoutY(340);
        startButton.setOnMouseEntered(e->{
            startButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        startButton.setOnMouseExited(e->{
            startButton.setStyle("-fx-background-color: #DAA520");
        });
        startButton.setOnMouseClicked(e-> {
            Main.scene = MapSelection();
            Main.Stage.setScene(Main.scene);
        });
        root.getChildren().add(startButton);

        map.drawBackground();
        starGame.play();
        starGame.loop();
        Scene MenuScene = new Scene(root);

        return MenuScene;
    }

    public Scene MapSelection() {
        Canvas canvas = new Canvas(96 * 16, 96 * 10);
        map.gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        // Easy Map button
        ImageView iv1 = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\Easy_Map.png"));
        Button EzMap = new Button("",iv1);
        EzMap.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        EzMap.setLayoutX(810);
        EzMap.setLayoutY(150);
        EzMap.setOnMouseEntered(e->{
            EzMap.setStyle("-fx-background-color: #FFFAF0;");
        });
        EzMap.setOnMouseExited(e->{
            EzMap.setStyle("-fx-background-color: #DAA520");
        });
        EzMap.setOnMouseClicked(e-> {
            Main.scene = EzGamePlay();
            Main.Stage.setScene(Main.scene);
            gameField.drawTowerEz();
            gameField.setMapType("ez");
        });

        // Difficult Map button
        ImageView iv2 = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\Difficult_Map.png"));
        Button DifMap = new Button("",iv2);
        DifMap.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        DifMap.setLayoutX(810);
        DifMap.setLayoutY(520);
        DifMap.setOnMouseEntered(e->{
            DifMap.setStyle("-fx-background-color: #FFFAF0;");
        });
        DifMap.setOnMouseExited(e->{
            DifMap.setStyle("-fx-background-color: #DAA520");
        });
        DifMap.setOnMouseClicked(e-> {
            Main.scene = DifGamePlay();
            Main.Stage.setScene(Main.scene);
            gameField.drawTowerDif();
            gameField.setMapType("dif");
        });

        // Back BuildButton
        ImageView iv3 = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\backButton.png"));
        iv3.setFitWidth(80);
        iv3.setFitHeight(80);
        Button BackButton = new Button("", iv3);
        BackButton.setShape(new Circle(40));
        BackButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        BackButton.setLayoutX(14 * 96 + 48);
        BackButton.setLayoutY(48);
        BackButton.setOnMouseEntered(e->{
            BackButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        BackButton.setOnMouseExited(e->{
            BackButton.setStyle("-fx-background-color: #DAA520");
        });
        BackButton.setOnMouseClicked(e-> {
            Main.scene = GameMenu();
            Main.Stage.setScene(Main.scene);
            gameField.setStartDefense("off");
        });

        root.getChildren().addAll(EzMap, DifMap, BackButton);

        map.drawMapSelectionBackground();

        Scene MapScene = new Scene(root);

        return MapScene;
    }


    public Scene EzGamePlay() {
        Canvas canvas = new Canvas(96 * 16, 96 * 10);
        map.gc = canvas.getGraphicsContext2D();
        gameField.gc = canvas.getGraphicsContext2D() ;
        // Back button
        ImageView iv = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\backButton.png"));
        iv.setFitWidth(80);
        iv.setFitHeight(80);
        Button BackButton = new Button("", iv);
        BackButton.setShape(new Circle(5));
        BackButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        BackButton.setLayoutX(14 * 96 + 65);
        BackButton.setLayoutY(8 * 96 + 68);
        BackButton.setOnMouseEntered(e->{
            BackButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        BackButton.setOnMouseExited(e->{
            BackButton.setStyle("-fx-background-color: #DAA520");
        });
        BackButton.setOnMouseClicked(e-> {
            Main.scene = GameMenu();
            Main.Stage.setScene(Main.scene);
            gameField.setStartDefense( "off");
            gameField.Timer.stop();
            gameField.resetGame();
            starGame.loop();
            game.stop();
        });

        // Pause button
        ImageView iv1 = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\pauseButton.png"));
        iv1.setFitWidth(80);
        iv1.setFitHeight(80);
        Button PauseButton = new Button("", iv1);
        PauseButton.setShape(new Circle(5));
        PauseButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        PauseButton.setLayoutX(13 * 96 + 15);
        PauseButton.setLayoutY(8 * 96 + 68);
        PauseButton.setOnMouseEntered(e->{
            PauseButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        PauseButton.setOnMouseExited(e->{
            PauseButton.setStyle("-fx-background-color: #DAA520");
        });
        PauseButton.setOnMouseClicked(e-> {
            gameField.EzPauseClick += 1;
            if (gameField.EzPauseClick % 2 == 1) {
                gameField.Timer.stop();
                gameField.setStartDefense("off");
            }
            else {
                gameField.setStartDefense("run");
                gameField.Timer.start();
            }
        });

        // Tao root
        Group root = new Group();
        root.getChildren().addAll(canvas, BackButton, PauseButton);
        // Tao sence de them vao stage
        Scene EzScene = new Scene(root);
        gameField.setMapType("ez");
        gameField.setStartDefense("run");
        gameField.Timer.start();
        starGame.stop();
        game.loop();
        return EzScene;
    }

    public Scene DifGamePlay() {
        Canvas canvas = new Canvas(96 * 16, 96 * 10);
        map.gc = canvas.getGraphicsContext2D();
        gameField.gc = canvas.getGraphicsContext2D() ;
        // Back button
        ImageView iv = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\backButton.png"));
        iv.setFitWidth(80);
        iv.setFitHeight(80);
        Button BackButton = new Button("", iv);
        BackButton.setShape(new Circle(5));
        BackButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        BackButton.setLayoutX(14 * 96 + 65);
        BackButton.setLayoutY(8 * 96 + 48);
        BackButton.setOnMouseEntered(e->{
            BackButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        BackButton.setOnMouseExited(e->{
            BackButton.setStyle("-fx-background-color: #DAA520");
        });
        BackButton.setOnMouseClicked(e-> {
            Main.scene = GameMenu();
            Main.Stage.setScene(Main.scene);
            gameField.setStartDefense("off");
            gameField.Timer.stop();
            gameField.resetGame();
            starGame.loop();
            game.stop();
        });

        // Pause button
        ImageView iv1 = new ImageView(new Image("file:D:\\Cules\\BTL_1\\images\\pauseButton.png"));
        iv1.setFitWidth(80);
        iv1.setFitHeight(80);
        Button PauseButton = new Button("", iv1);
        PauseButton.setShape(new Circle(5));
        PauseButton.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
        PauseButton.setLayoutX(13 * 96 + 45);
        PauseButton.setLayoutY(8 * 96 + 48);
        PauseButton.setOnMouseEntered(e->{
            PauseButton.setStyle("-fx-background-color: #FFFAF0;");
        });
        PauseButton.setOnMouseExited(e->{
            PauseButton.setStyle("-fx-background-color: #DAA520");
        });
        PauseButton.setOnMouseClicked(e-> {
            gameField.DifPauseClick += 1;
            if (gameField.DifPauseClick % 2 == 1) {
                gameField.Timer.stop();
                gameField.setStartDefense("off");
            }
            else {
                gameField.setStartDefense("run");
                gameField.Timer.start();
            }
        });

        // Tao root
        Group root = new Group();
        root.getChildren().addAll(canvas, BackButton, PauseButton);
        // Tao sence de them vao stage
        Scene DifScene = new Scene(root);
        gameField.setMapType("dif");
        gameField.setStartDefense("run");
        gameField.Timer.start();
        game.loop();
        starGame.stop() ;

        return DifScene;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
}

