package Bullet;
import Enemy.Enemy;
import GameObject.GameObject;
//import Main.Manager;
import Main.Direction;
import Main.Main;
import Tower.Tower;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import GameObject.MovebleObject ;
import GameObject.Sound ;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;
import java.util.List;



public class Bullet extends MovebleObject {
    double gunRotation ;
    double gunRotationmove ;
    Enemy target ;
    Tower tower ;
    List<Enemy> Lenemy ;
    boolean isDestroy ,shoot ;
    private ArrayList<Bullet> bullets;
    int dame ;
    long createBullet ;
    public void setGunRotation(double gunRotation) {
        this.gunRotation = gunRotation;
    }
    public double getGunRotation() {
        return gunRotation;
    }
    protected Sound hitEnemy ;
    private int buX, buY;

    public Bullet(int x , int y , Enemy target, String img , int dame, Tower tower , int speed ) {
       this.x = x ;
       this.buX = x;
       this.y = y ;
       this.buY = y;
       this.target = target ;
       this.img =  new Image("file:D:\\Cules\\BTL_1\\images\\towerDefense_tile" + img + ".PNG") ;
       this.dame = dame ;
       this.tower = tower ;
       this.speed = speed ;
       this.hitEnemy = new Sound("audio\\bum.wav") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(img);
        iv.setRotate(gunRotationmove);
        Image bullet = iv.snapshot(params, null);
        if (gunRotationmove >= 0) {
            gc.drawImage(bullet, x + 20 , y + 5 , 80, 80);
        }
        else {
            gc.drawImage(bullet, x - 20 , y + 5 , 80 , 80 );
        }
    }
    @Override
    public void update() {
        recalculateVector(tower.getX(),tower.getY());
        this.gunRotationmove = tower.getGunRotation() ;

    }

    public void recalculateVector(int destX ,int destY) {
            int distance = (int) distance(x, y, target.getX(), target.getY());
            distance /= 50;
            if (!tower.isDisRange()) shoot = false;
            if (distance != 0) {
                shoot = true;
                if (target.getX() < tower.getX())
                    this.gunRotation = -(double) (Math.atan2(destX - target.getX(), target.getY() - destY));
                else {
                    this.gunRotation = Math.abs((double) (Math.atan2(destX - target.getX(), target.getY() - destY)));
                }
                this.x += (int) (Math.sin(gunRotation) * speed);
                this.y += (int) (Math.cos(gunRotation) * speed);
            } else {
                if (Math.abs(target.getX() - x)  <= speed && Math.abs(target.getY() - y) <= speed)  shoot = false ;
                isDestroy = true;
                if (target.getHealth() <= dame) {
                    target.setHealth(0);
                    target.setAlive(false);
                    hitEnemy.play();

                } else {
                    target.setHealth(getHealth() - dame);
                }
            }
    }


    public void setDestroy(boolean destroy) { isDestroy = destroy; }

    public boolean isDestroy() { return isDestroy; }

    public boolean isShoot() {
        return shoot;
    }
}
