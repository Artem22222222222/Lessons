public class Model implements IModel{

    public void typeC(Controler c){
        c.ui.button1.setBounds(c.ui.button1.getX(),c.ui.button1.getY()+10, c.ui.button1.getWidth(), c.ui.button1.getHeight());

    }
    public void typeD(Controler c){
        c.ui.button1.setBounds(c.ui.button1.getX()+10,c.ui.button1.getY(), c.ui.button1.getWidth(), c.ui.button1.getHeight());

    }
}
