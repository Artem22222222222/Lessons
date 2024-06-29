import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controler implements IController, KeyListener {
    UI ui;
    Model model;

    public Controler() {
        this.ui = new UI(this);
        ui.button1.addKeyListener(this);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 's':
                model.typeC(this);
                break;
            case 'd':
                model.typeD(this);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public UI getUi() {
        return ui;
    }
}
