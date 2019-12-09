package Main.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
    public GraphicsContext gc ;
    public void drawBackground() {
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\BackGround1.png"),0, 0, 96*16, 96*10);
        //GameTowerDefense.gc.drawImage(new Image("file:E:\\java project\\Javafx\\images\\StartButton.png"),900, 340);
    }
    public void drawMapSelectionBackground() {
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\MapBackGround.png"),0, 0, 96*16, 96*10);
    }
    public void drawGameTable(GraphicsContext gc) {
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\table1.png"), 96 * 13, 0);
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\MachineGunTower.png"), 96 * 13 + 23, 60, 90, 90);
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\NormalTower.png"), 96 * 13 + 165, 60, 90, 90);
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\SniperTower.png"), 96 * 13 + 23, 195, 90, 90);
        gc.drawImage(new Image("file:D:\\Cules\\BTL_1\\images\\RocketTower.png"), 96 * 13 + 165, 195, 90, 90);
        //GameTowerDefense.gc.drawImage(new Image("file:E:\\java project\\Javafx\\images\\backButton.png"), 15 * 96, 96 * 9, 96, 96);
        //GameTowerDefense.gc.drawImage(new Image("file:E:\\java project\\Javafx\\images\\pauseButton.png"), 13 * 96 + 48, 96 * 9 + 5, 90, 90);
    }


}
