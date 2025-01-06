import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    Model m;
    UI ui;
    Controller(Model m){
        ui=new UI(this);
        this.m=m;
        m.setControler(this);
    }
    public void click(){
        m.print();
    }
    public void sendTexttoUI(String s){
        ui.print(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        click();
    }
}