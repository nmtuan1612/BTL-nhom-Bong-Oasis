package Main;

public enum Direction {
    LEFT(180), RIGHT(0), DOWN(90), UP(270) ;

    int degree;
    Direction(int i) {
        degree = i;
    }

    public int getDegree() {
        return degree;
    }
}
