package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MonsterButton extends JButton {
    private UI ui;
    private Image monster;
    private int width;
    private int height;
    private Random r;
    int x = 0;
    int y = 0;
    int stepX;
    int stepY;
    private boolean alive = true;
    private double heroDistance;

    public MonsterButton(UI ui, int width, int height) {
        this.ui = ui;
        this.width = width;
        this.height = height;
        r = new Random();
        try {
            monster = ImageIO.read(new File("src/main/java/game/resources/Monster.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setBounds(2000, r.nextInt(100, 700), width, height);
        setPreferredSize(new Dimension(width, height));
        Thread moveMonster = new Thread(this::moveMonster);
        moveMonster.start();
    }

    public synchronized void setMove(int stepX, int stepY) {
        int oldX = getX();
        int oldY = getY();
        int moveX;
        int moveY;
        if (stepX > 0) {
            moveX = 1;
        } else {
            moveX = -1;
        }
        if (stepY > 0) {
            moveY = 1;
        } else {
            moveY = -1;
        }
        while (oldX + stepX != getX() || oldY + stepY != getY()) {
            if (oldX + stepX != getX() && oldY + stepY != getY()) {
                super.setBounds(getX() + moveX, getY() + moveY, width, height);
                repaint();
            } else if (oldX + stepX != getX()) {
                super.setBounds(getX() + moveX, getY(), width, height);
                repaint();
            }
            if (oldY + stepY != getY()) {
                super.setBounds(getX(), getY() + moveY, width, height);
                repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(monster, 0, 0, width, height, this);
    }

    public void moveMonster(){
        double villageDistance;
        while (alive && !ui.getHero().isGameEnd()) {
             heroDistance = Math.pow((Math.pow((ui.getHero().getX() + 25) - (this.getX() + 25), 2) + Math.pow((ui.getHero().getY() - 25) - (this.getY() - 25), 2)), 0.5);
             villageDistance = getX() - 400;
             if (heroDistance < 11){
                 ui.getHero().setGameEnd(true);
             }else if (villageDistance < 11){
                 ui.getHero().setGameEnd(true);
             }else if (Math.abs(heroDistance) < villageDistance) {
                 if (ui.getHero().getX() == getX()){
                     stepX = 0;
                     stepY = (((ui.getHero().getY() - getY()) * 10) / (Math.abs(ui.getHero().getY() - getY())));
                     setMove(stepX, stepY);
                 }else if (ui.getHero().getY() == getY()){
                     stepX = (((ui.getHero().getX() - getX()) * 10) / (Math.abs(ui.getHero().getX() - getX())));
                     stepY = 0;
                     setMove(stepX, stepY);
                 }else {
                     stepX = (((ui.getHero().getX() - getX()) * 10) / (Math.abs(ui.getHero().getX() - getX())));
                     stepY = (((ui.getHero().getY() - getY()) * 10) / (Math.abs(ui.getHero().getY() - getY())));
                     setMove(stepX, stepY);
                 }
            } else if (Math.abs(heroDistance) > villageDistance) {
                 stepX = -10;
                 stepY = 0;
                 setMove(stepX, stepY);
            }else {
                 stepX = -10;
                 stepY = 0;
                 setMove(stepX, stepY);
            }
//             System.out.println(getX());
//             System.out.println(getY());
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getHeroDistance() {
        return heroDistance;
    }

    public void setHeroDistance(double heroDistance) {
        this.heroDistance = heroDistance;
    }
}
