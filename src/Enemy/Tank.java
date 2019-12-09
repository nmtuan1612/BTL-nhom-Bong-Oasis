package Enemy;

import GameObject.GameObject;
import Main.Direction;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Tank extends Enemy {
    public Tank(int i, int j, Direction direction) {
        super(i, j, direction);
        this.health = 150;
        this.setSpeed(6);
        this.setReward(100);
        this.img = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile268.PNG") ;
        this.gunImg = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile291.PNG");
    }
}
