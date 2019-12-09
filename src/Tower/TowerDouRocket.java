package Tower;

public class TowerDouRocket extends Tower {

    public TowerDouRocket(int i, int j) {
        super(i, j, "204", "252");
        this.damage = 300 ;
        this.setSpeed_bullet(20);
        this.fireRange = 400 ;
        this.fireRate = 25 ;
        this.price = 2000 ;
        this.rank = 4 ;
    }
}
