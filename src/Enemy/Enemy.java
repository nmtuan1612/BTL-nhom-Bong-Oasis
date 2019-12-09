package Enemy;

import GameObject.MovebleObject ;
import Main.Direction;
//import Main.Manager;
import Main.GameField;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import Main.Point ;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import Main.Map.*;


public class Enemy extends MovebleObject {
    protected Image gunImg;
    int WpX ;
    int wayPointIndex = 0;
    Rectangle outerHealthRect;
    Rectangle innerHealthRect;
    double height = 10;
    int heathBar ;
    boolean isAlive ;
    double outerWidth = 60;
    double innerWidth = 40;
    int heathMax ;
    boolean ReachTarget = false;
    MapEz EzWay = new MapEz();
    MapDif DifWay = new MapDif() ;
    String mapType = null ;

    public Enemy(int i , int j , Direction direction) {
        this.i  = i ;
        this.j = j ;
        this.x = 96 * i + 48 ;
        this.y = 96 * j ;
        this.isAlive = true ;
        this.direction = direction ;
    }

    public Point getNextDifWayPoint() {
        if (wayPointIndex < DifWay.DifWayPoints.length - 1)
            return DifWay.DifWayPoints[++wayPointIndex];
        return null;
    }

    public Point getNextEzWayPoint() {
        if (wayPointIndex < EzWay.EzWayPoints.length - 1)
            return EzWay.EzWayPoints[++wayPointIndex];
        return null;
    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(img);
        iv.setRotate(this.direction.getDegree());
        Image base = iv.snapshot(params, null);
        if (gunImg != null) {
            ImageView iv2 = new ImageView(gunImg);
            iv2.setRotate(this.direction.getDegree());
            Image gun = iv2.snapshot(params, null);
            gc.drawImage(base, x, y, 96, 96);
            gc.drawImage(gun, x, y, 96, 96);
        }
        else {
            gc.drawImage(base, x, y, 96, 96);
        }
        HeathBar(gc);

    }

    void caculateDirection() {
        // Tim huong di tiepc theo cho Object

        if (mapType == "dif") {
            if (wayPointIndex >= DifWay.DifWayPoints.length) {
                // Den dich
                return;
            }

            Point curWayPoint = DifWay.DifWayPoints[wayPointIndex];
            if (distance(x, y, curWayPoint.x, curWayPoint.y) <= speed) {
                x = curWayPoint.x;
                y = curWayPoint.y;
                WpX = x;

                Point nextWayPoint = getNextDifWayPoint();
                if (nextWayPoint == null) return;
                double deltaX = nextWayPoint.x - x;
                double deltaY = nextWayPoint.y - y;
                if (deltaX > speed) direction = Direction.RIGHT;
                else if (deltaX < -speed) direction = Direction.LEFT;
                else if (deltaY > speed) direction = Direction.DOWN;
                else if (deltaY <= -speed) direction = Direction.UP;
            }
        }

        if (mapType == "ez") {
            if (wayPointIndex >= EzWay.EzWayPoints.length) {
                // Den dich
                return;
            }

            Point curWayPoint = EzWay.EzWayPoints[wayPointIndex];
            if (distance(x, y, curWayPoint.x, curWayPoint.y) <= speed) {
                x = curWayPoint.x;
                y = curWayPoint.y;
                WpX = x;

                Point nextWayPoint = getNextEzWayPoint();
                if (nextWayPoint == null) return;
                double deltaX = nextWayPoint.x - x;
                double deltaY = nextWayPoint.y - y;
                if (deltaX > speed) direction = Direction.RIGHT;
                else if (deltaX < -speed) direction = Direction.LEFT;
                else if (deltaY > speed) direction = Direction.DOWN;
                else if (deltaY <= -speed) direction = Direction.UP;
            }
        }
    }

    @Override
    public void update() {
        caculateDirection();

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed ;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed ;
                break;
        }
        if (health == 0) heathBar = 30 ;
    }
    /*void EnemyReachTarget() {
        if (getX() >= 96 * 13 - speed) ReachTarget = true;
    }*/
    public void setGunImg(Image gunImg) {
        this.gunImg = gunImg;
    }

    void HeathBar(GraphicsContext gc) {
        gc.fillRect(x , y + 30 ,  8 , 30);
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(x , y + 30 , 8 , 30);
        gc.setFill(Color.RED);
 }

    public void setHeathBar(int heathBar) { this.heathBar = heathBar; }
    public int getHeathBar() { return heathBar; }
    public void setMapType(String mapType) { this.mapType = mapType; }
    public String getMapType() { return mapType; }
    public void setValue(double value) {
        innerHealthRect.setWidth(outerHealthRect.getWidth() * value);
    }
    public void setAlive(boolean alive) { isAlive = alive; }
    public boolean isAlive() {
        return isAlive;
    }
}
