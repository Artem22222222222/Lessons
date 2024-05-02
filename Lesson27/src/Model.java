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
                c.getUi().setHeroY(-10);
                break;
            case 'a':
                c.getUi().setHeroX(-10);
                break;
            case 'd':
                System.out.println("move success");
                c.getUi().setHeroX(10);

                if (!c.getUi().getHero().isGoRightEver()){
                    right = new Thread(this.c.getUi().getHero()::moveRight);
                    right.start();
                    c.getUi().getHero().setGoRightEver(true);
                }
                c.getUi().getHero().setGoRight(true);
                break;
            case 's':
                c.getUi().setHeroY(10);
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
