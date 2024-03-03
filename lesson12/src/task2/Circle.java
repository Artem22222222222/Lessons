package task2;

import task2.GraphicObject;

public class Circle extends GraphicObject {
    int radius;

    public Circle(int posX, int posY, String color, int id, int radius) {
        super(posX, posY, color, id);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getType(){
        return "task2.Circle";
    }
    public void setSize(int[] size){
        setRadius(size[0]);
   }
}
