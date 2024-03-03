package task2;

public class GraphicEditor {
    private GraphicObject[] objects;
    private int len = 0;
    GraphicEditor(){
        this.objects = new GraphicObject[10];
    }
    public void add(int posX, int posY, String color,int id, int direction, int length){
        objects[len] = new Line(posX, posY, color, id, direction, length);
        len++;
    }
    public void add(int posX, int posY, String color, int id, int direction, int side1, int side2){
        objects[len] = new Rectangle(posX, posY, color, id, direction, side1, side2);
        len++;
    }
    public void add(int posX, int posY, String color, int id, int radius){
        objects[len] = new Circle(posX, posY, color, id, radius);
        len++;
    }
    public void draw(int id){
        int a = 0;
        for (int i = 0; i < len; i++){
            if (objects[i].getId() == id){
                System.out.println(objects[i].getType());
                System.out.println("x - "+objects[i].getPosX());
                System.out.println("y - "+objects[i].getPosY());
                System.out.println("color - "+objects[i].getColor());
                a++;
            }
        }
        if (a == 0){
            System.out.println("error, id not found");
        }
    }
    public void move (int id, int posX, int posY){
        int a = 0;
        for (int i = 0; i < len; i++){
            if (objects[i].getId() == id){
                objects[i].setPosX(posX);
                objects[i].setPosY(posY);
                a++;
            }
        }
        if (a == 0){
            System.out.println("error, id not found");
        }
    }
    public void changeColor(int id, String color){
        int a = 0;
        for (int i = 0; i < len; i++){
            if (objects[i].getId() == id){
                objects[i].setColor(color);
                a++;
            }
        }
        if (a == 0){
            System.out.println("error, id not found");
        }
    }
    public void changeSizeLine(int id, int[] size){
        int a = 0;
        for (int i = 0; i < len; i++){
            if (objects[i].getId() == id){
                objects[i].setSize(size);
                a++;
            }
        }
        if (a == 0){
            System.out.println("error, id not found");
        }
    }
//    public void changeSizeCircle(int id, int radius){
//
//    }
//    public void changeSizeRectangle(int id, int radius){
//
//    }
}
