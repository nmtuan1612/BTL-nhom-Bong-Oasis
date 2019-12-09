package Tower;

public class TowerRocket extends Tower {
    public TowerRocket(int i, int j) {
        super(i, j, "206", "252");
        this.damage = 150 ;
        this.setSpeed_bullet(15);
        this.fireRange = 400 ;
        this.fireRate = 20 ;
        this.price = 1000 ;
        this.rank = 3 ;
    }
}
