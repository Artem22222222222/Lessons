
public class Model2 implements Model {
    Controller c;

    public void setControler(Controller c) {
        this.c = c;
    }

    public void print(){
        c.sendTexttoUI("Hi");
    }
}
