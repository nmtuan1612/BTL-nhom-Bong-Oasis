package Tower;

import javafx.scene.image.Image;

public class BaseTower extends Tower {
    public BaseTower(int i, int j,String img , String gunImg, String bullet) {
        super(i, j, gunImg, bullet);
        this.img = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile"+ img +".PNG") ;
        this.damage = 0 ;
        this.setSpeed_bullet(0);
        this.setFireRange(0);
        this.setPrice(0);
        this.rank = 0 ;
    }
}
