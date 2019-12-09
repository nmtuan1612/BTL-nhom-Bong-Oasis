package GameObject;

import Main.Direction;

public abstract class AttackableObject extends VulnerableObject {
    protected int damage;
    protected int fireRate;
    protected int fireRange;
    public Direction direction;
    protected AttackableObject() {
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setFireRange(int fireRange) {
        this.fireRange = fireRange;
    }

    public void setFireRate(int fireRate) { this.fireRate = fireRate; }

    public double getDamage() {
        return damage;
    }

    public double getFireRange() {
        return fireRange;
    }

    public double getFireRate() {
        return fireRate;
    }
}
