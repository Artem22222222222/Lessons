package task2;

public class GraphicObject {
        private int posX;
        private int posY;
        private String color;
        private int id;

    public GraphicObject(int posX, int posY, String color, int id) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getColor() {
        return color;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType(){
        return "";
    }
    public void setSize(int[] size){

    }
}
