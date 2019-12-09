package GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
    protected int i;
    protected int j;
    protected int x , xCen;
    protected int y , yCen;
    protected   Image img;
    public GameObject(int x, int y) {
    }

    protected GameObject() {
    }

    public double distance(int x1, int y1 , int x2, int y2 ) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


    public void setX(int x) { this.x = x; }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setJ(int j) { this.j = j; }
    public void setI(int i) { this.i = i; }
    public int getJ() {return j; }
    public int getI() { return i; }
    public void setImg(Image img) {
        this.img = img;
    }
    public Image getImg() {
        return img;
    }
    public void setxCen(int xCen) {
        this.xCen = this.x + 48;
    }
    public void setyCen(int yCen) {
        this.yCen = yCen + 48;
    }
    public int getxCen() { return xCen; }
    public int getyCen() { return yCen; }
    public abstract void render(GraphicsContext gc);
    public abstract void update();

}
