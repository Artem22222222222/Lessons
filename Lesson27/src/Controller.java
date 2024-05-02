import javax.net.ssl.KeyManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements IController, KeyListener, KeyManager {
    private UI ui;
    private Model model;



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        model.keyTyped(e);
        System.out.println("move");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ui.getHero().setGoRight(false);
        System.out.println("Stop move");
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
        this.ui.getHero().addKeyListener(this);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


}
