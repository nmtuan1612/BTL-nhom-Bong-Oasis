package Tower;

import javafx.scene.image.Image;

public class TowerDouGun extends Tower {
    public TowerDouGun(int i, int j) {
        super(i, j, " 250", "275");
        this.gunImg = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile250.PNG") ;
        this.damage = 30 ;
        this.setSpeed_bullet(30);
        this.fireRange = 200 ;
        this.fireRate = 10 ;
        this.price = 300 ;
        this.bullet = "275" ;
        this.rank = 2 ;
    }
}
