package Tower;

public class TowerGun extends Tower {
    public TowerGun(int i, int j) {
        super(i, j, "249", "272");
        this.damage = 30 ;
        this.setSpeed_bullet(20);
        this.fireRange = 200 ;
        this.fireRate = 15 ;
        this.price = 150 ;
        this.rank = 1 ;
    }
}
