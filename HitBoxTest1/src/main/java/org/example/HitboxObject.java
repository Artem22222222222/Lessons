package org.example;

public class HitboxObject {
    private int x;
    private int y;
    private int range;

    public HitboxObject(int x, int y, int range) {
        this.x = x;
        this.y = y;
        this.range = range;
    }

    public boolean calculate(int targetX, int targetY){
        return Math.sqrt(targetX-x)+Math.sqrt(targetY-y) == Math.sqrt(range);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
