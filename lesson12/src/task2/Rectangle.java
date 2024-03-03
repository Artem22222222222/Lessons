package task2;

import task2.GraphicObject;

public class Rectangle extends GraphicObject {
    int direction;
    int side1;
    int side2;

    public Rectangle(int posX, int posY, String color, int id, int direction, int side1, int side2) {
        super(posX, posY, color, id);
        this.direction = direction;
        this.side1 = side1;
        this.side2 = side2;
    }

    public int getDirection() {
        return direction;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public String getType(){
        return "task2.Rectangle";
    }
    public void setSize(int[] size){
        setSide1(size[0]);
        setSide2(size[1]);
    }
}
