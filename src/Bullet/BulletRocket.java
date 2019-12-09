package Bullet;

import Enemy.Enemy;
import Tower.Tower;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class BulletRocket extends Bullet{

    public BulletRocket(int x, int y, Enemy target, String img, int dame, Tower tower, int speed) {
        super(x, y, target, img, dame, tower, speed);
    }
    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(img);
        iv.setRotate(gunRotationmove);
        Image bullet = iv.snapshot(params, null);
        gc.drawImage(bullet, x, y , 96, 96);
    }
}
