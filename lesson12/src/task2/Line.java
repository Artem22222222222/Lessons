package task2;

import task2.GraphicObject;

public class Line extends GraphicObject {
    int direction;
    int length;

    public Line(int posX, int posY, String color, int id, int direction, int length) {
        super(posX, posY, color, id);
        this.direction = direction;
        this.length = length;
    }

    public int getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType(){
        return "task2.Line";
    }
    public void setSize(int[] size){
        setLength(size[0]);
    }
}
