public class Model3 implements Model{
    Controller c;
    @Override
    public void setControler(Controller c) {
        this.c=c;
    }

    @Override
    public void print() {
        c.sendTexttoUI("Pepa");
    }
}
