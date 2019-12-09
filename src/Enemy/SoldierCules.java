package Enemy;

import Main.Direction;
import javafx.scene.image.Image;

public class SoldierCules extends Enemy {
    public SoldierCules(int i, int j , Direction direction) {
        super(i, j, direction);
        this.health = 50 ;
        this.speed = 10 ;
        this.setReward(50);
        this.img = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile247.PNG") ;
        this.gunImg = null ;
    }
}
