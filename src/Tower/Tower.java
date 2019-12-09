package Tower;
import GameObject.AttackableObject;
//import Main.Manager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import Bullet.Bullet ;
import Bullet.BulletRocket ;
import java.util.ArrayList;
import java.util.List;
import Enemy.Enemy ;
import GameObject.Sound ;

public class Tower extends AttackableObject {
    private double speed_bullet;
    protected Image gunImg;
    protected double gunRotation;
    protected boolean disRange;
    private List<Enemy> enemy;
    private ArrayList<Bullet> bullets;
    protected Enemy target;
    protected String bullet;
    protected int price, rank;
    protected long lastShoot;
    protected Sound startSound, attackSound;

    public Tower(int i, int j, String gunImg, String bullet) {
        this.setI(i);
        this.setJ(j);
        this.x = this.i * 96;
        this.y = this.j * 96;
        this.img = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile180.PNG");
        this.gunImg = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile" + gunImg + ".PNG");
        this.bullet = bullet;
        bullets = new ArrayList<>();
        this.attackSound = new Sound("audio\\shot.wav") ;

    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(gunImg);
        iv.setRotate(gunRotation);
        Image gun = iv.snapshot(params, null);
        gc.drawImage(getImg(), getX(), getY(), 96, 96);
        gc.drawImage(gun, getX(), getY(), 96, 96);
    }

    @Override
    public void update() {
        for (Bullet bullet : bullets) bullet.update();

    }

    public void renderTower(GraphicsContext gc) {
        render(gc);
        for (Bullet bullet : bullets) bullet.render(gc);
    }


    public void attack(ArrayList<Enemy> targetList) {
        if (fireRange == 0) return;
        else {
            this.disRange = false;
            if (this.rank == 3 || this.rank == 4) {
                this.gunImg = new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile206.PNG");
            }
            while (!bullets.isEmpty() && bullets.get(0).isDestroy() && disRange == false) bullets.remove(0);
            for (int i = 0 ; i < bullets.size() ; i++)
                if (!bullets.get(i).isShoot()) bullets.remove(i) ;
            for (Enemy target : targetList) {
                int desX = target.getX() + 48;
                int desY = target.getY() + 48;
                if ((distance(this.getX() + 48, this.getY() + 48, desX, desY) < this.fireRange) && (target.getHealth() > 0)) {
                    this.disRange = true;
                    if (this.x > target.getX())
                        gunRotation = mathGunRotation(target) - 90;
                    else
                        gunRotation = 90 - mathGunRotation(target);
                    if (this.rank == 3 || this.rank == 4) {
                        if (System.currentTimeMillis() - lastShoot >= 50 * fireRate ) {
                            bullets.add(new BulletRocket(getX(), getY(), target, bullet, (int) getDamage(), this, (int) getSpeed_bullet()));
                            lastShoot = System.currentTimeMillis();
                            attackSound.play();
                        }
                        try {
                            if (bullets.get(0).isShoot()) {
                                this.gunImg = null;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("den");
                        }
                    } else if (System.currentTimeMillis() - lastShoot >= 50 * fireRate) {
                        bullets.add(new Bullet(getX(), getY(), target, bullet, (int) getDamage(), this, (int) getSpeed_bullet()));
                        lastShoot = System.currentTimeMillis() ;
                        attackSound.play();
                    }
                }
            }
        }
    }
    double mathGunRotation(Enemy enemy) {
        int enemyX = enemy.getX() ;
        int enemyY = enemy.getY();
        int tdX = this.getX() + 96 * 2 , tdY = this.getY() + 48 ;
        int cenX = this.getxCen(),cenY = this.getY() ;
        double oi = distance(tdX , tdY , cenX , cenY) ;
        double ai = Math.sqrt(Math.pow(fireRange , 2 ) - Math.pow(oi , 2)) ;
        double alp = (180/Math.PI) * Math.atan((tdY - enemyY) / oi);
        return alp;
    }




    public boolean isDisRange() { return disRange; }
    public void setGunRotation(double gunRotation) { this.gunRotation = gunRotation; }
    public double getGunRotation() { return gunRotation; }
    public void setSpeed_bullet(double speed_bullet) { this.speed_bullet = speed_bullet; }
    public double getSpeed_bullet() { return speed_bullet; }
    public void setDisRange(boolean disRange) { this.disRange = disRange; }
    public void setPrice(int price) { this.price = price; }
    public int getPrice() { return price; }
    public void setRank(int rank) { this.rank = rank; }
    public int getRank() { return rank; }
}
