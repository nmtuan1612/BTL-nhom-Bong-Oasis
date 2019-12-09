package GameObject;

import Main.Direction;
import javafx.scene.control.skin.TextInputControlSkin;

public abstract class MovebleObject extends VulnerableObject{
    protected double speed;
    double reward;
    public Direction direction;
    public MovebleObject(int x , int y, double speed) {
        this.x = x ;
        this.y = y ;
        this.speed = speed ;
    }
    public MovebleObject(int x , int y , double speed ,int heath ,double reward) {
        super(x, y,heath);
        this.speed = speed ;
        this.reward = reward;
    }

    protected MovebleObject() {
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getReward() {
        return reward;
    }

    public double getSpeed() {
        return speed;
    }
}
