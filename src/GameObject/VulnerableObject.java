package GameObject;

import javafx.scene.canvas.GraphicsContext;

public abstract class VulnerableObject extends GameObject {
       protected int health;

    protected VulnerableObject() {
    }

    public void setHealth(int health) { this.health = health ; }
    public int getHealth() {
        return health;
    }

    public VulnerableObject(int x, int y , int health) {
            super(x,y);
            this.health = health ;
        }

}
