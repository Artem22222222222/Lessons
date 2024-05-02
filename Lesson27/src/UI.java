import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UI implements IUI{
    private JFrame mainFrame;
    private ViewButton hero;
    private Controller controller;
    private JPanel players;
    private int heroWidth = 273;
    private int heroHeight = 288;
    public UI(Controller controller) {
        this.controller = controller;
        mainFrame = new JFrame();
        mainFrame.setBounds(0,0,1000, 500);
//        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        players = new JPanel();
        hero = new ViewButton(this);
        hero.setBounds(100, 50, heroWidth, heroHeight);

        players.add(hero);
        players.setLayout(null);
        mainFrame.add(players);
        players.setVisible(true);
        mainFrame.repaint();
    }
    public void setHeroX(int a){
        hero.setBounds(hero.getX()+a, hero.getY(), heroWidth, heroHeight);
    }
    public void setHeroY(int a){
        hero.setBounds(hero.getX(), hero.getY()+a, heroWidth, heroHeight);
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
}
