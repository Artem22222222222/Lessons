package game;

import javax.swing.*;

public class UI {
    private Controller controller;
    private HeroButton hero;
    private JFrame mainLand;
    private Background mainLandBackground;

    public UI(Controller controller) {
        this.controller = controller;
        hero = new HeroButton(this, 50, 50);
        mainLand = new JFrame("Game");
        mainLand.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainLand.setLayout(null);
        mainLand.setBounds(0, 0, 5000, 825);

        mainLandBackground = new Background();
        mainLandBackground.setLayout(null);
        mainLandBackground.setBounds(0, 0, 5000, 825);
        mainLandBackground.setVisible(true);

        hero.setBounds(0, 725, 50, 50);

        mainLandBackground.add(hero);

        mainLand.add(mainLandBackground);
        mainLand.pack();
        mainLand.setVisible(true);

        StringMessages.gameStart();
    }

    public static class StringMessages {
        public static void gameStart() {
            System.out.println("**********");
            System.out.println("Game start");
            System.out.println("**********");
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public HeroButton getHero() {
        return hero;
    }

    public void setHero(HeroButton hero) {
        this.hero = hero;
    }

    public JFrame getMainLand() {
        return mainLand;
    }

    public void setMainLand(JFrame mainLand) {
        this.mainLand = mainLand;
    }

    public Background getMainLandBackground() {
        return mainLandBackground;
    }

    public void setMainLandBackground(Background mainLandBackground) {
        this.mainLandBackground = mainLandBackground;
    }
}
