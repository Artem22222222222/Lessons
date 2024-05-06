import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UI implements IUI{
    private JFrame mainFrame;
    private ViewButton hero;
    public Label Background;
    private Controller controller;
    private Background players;
    private int heroWidth = 273;
    private int heroHeight = 288;
    public UI(Controller controller) {
        this.controller = controller;
        mainFrame = new JFrame();
        mainFrame.setBounds(0,0,1000, 702);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        players = new Background();
        hero = new ViewButton(this);
        hero.setBounds(100, 50, heroWidth, heroHeight);


        players.add(hero);
        players.setLayout(null);
        mainFrame.add(players);
        players.setVisible(true);
//        mainFrame.repaint();
        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public ViewButton getHero() {
        return hero;
    }

    public void setHero(ViewButton hero) {
        this.hero = hero;
    }

    public Controller getC() {
        return controller;
    }

    public void setC(Controller c) {
        this.controller = c;
    }

    public Background getPlayers() {
        return players;
    }

    public void setPlayers(Background players) {
        this.players = players;
    }
}
