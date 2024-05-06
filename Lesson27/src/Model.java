import java.awt.event.KeyEvent;

public class Model implements IModel{
    private Controller c;

    private Thread right;

    public Model(Controller c) {
        this.c = c;
    }



    public void keyTyped(KeyEvent e){
        switch (e.getKeyChar()){
            case 'w':
                break;
            case 'a':
                break;
            case 'd':
                c.getUi().getHero().setGoRight(true);

                c.getUi().getPlayers().setGoRight(true);

                if (!c.getUi().getHero().isGoRightEver()){
                    c.getUi().getHero().setGoRightEver(true);
                    right = new Thread(this.c.getUi().getHero()::moveRight);
                    right.start();
                }

                if (!c.getUi().getPlayers().isGoRightEver()) {
                    c.getUi().getPlayers().setGoRightEver(true);
                    right = new Thread(this.c.getUi().getPlayers()::moveRight);
                    right.start();
                }
                break;
            case 's':
                break;
        }
    }

    public Controller getC() {
        return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }
}
