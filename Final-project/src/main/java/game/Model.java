package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Model implements KeyListener {
    private Controller controller;
    Spawn spawn;
    private ArrayList<MonsterButton> monsters = new ArrayList<>();

    public Model(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (spawn == null){
            spawn = new Spawn(controller.getUi(), 5);
        }
        switch (e.getKeyChar()){
            case 'w':
                controller.getUi().getHero().setGoUp(true);
                break;

            case 's':
                controller.getUi().getHero().setGoDown(true);
                break;

            case 'a':
                controller.getUi().getHero().setGoLeft(true);
               break;

            case 'd':
                controller.getUi().getHero().setGoRight(true);
                break;
            case 'x':
                for (MonsterButton m:monsters) {
                    if (m.getHeroDistance() < 200){
                        m.setAlive(false);
                        monsters.remove(m);
                        controller.getUi().getMainLandBackground().remove(m);
                        m.repaint();
                        return;
                    }
                }
                break;
            case '0':
                controller.getUi().getHero().setGameEnd(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                controller.getUi().getHero().setGoUp(false);
                break;
            case 's':
                controller.getUi().getHero().setGoDown(false);
                break;
            case 'a':
                controller.getUi().getHero().setGoLeft(false);
                break;
            case 'd':
                controller.getUi().getHero().setGoRight(false);
                break;
        }
    }

    public ArrayList<MonsterButton> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<MonsterButton> monsters) {
        this.monsters = monsters;
    }
}
