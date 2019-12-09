package Enemy;

import Main.Direction;
import javafx.scene.image.Image;

public class Soldier extends Enemy {

    public Soldier(int i, int j, Direction direction) {
        super(i, j, direction);
        this.health = 30 ;
        this.setReward(30);
        this.speed = 5 ;
        this.img = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile245.PNG") ;
        this.gunImg = null ;
    }
}
