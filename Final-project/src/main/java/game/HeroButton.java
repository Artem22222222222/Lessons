package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HeroButton extends JButton {
    private final Object syncObject = new Object();
    private Image hero;
    private UI ui;
    private boolean goRight = false;
    private boolean goLeft = false;
    private boolean goUp = false;
    private boolean goDown = false;

    private int x = 0;
    private int y = 0;
    private int width;
    private int height;
    private boolean gameEnd = false;

    public HeroButton(UI ui, int width, int height) {
        this.ui = ui;
        this.width = width;
        this.height = height;
        try {
            hero = ImageIO.read(new File("src/main/java/game/resources/Hero.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setPreferredSize(new Dimension(width, height));
        Thread moveHero = new Thread(this::moveHero);
        moveHero.start();
    }

    public void moveHero(int stepX, int stepY) {
        int oldX = getX();
        int oldY = getY();
        int move;
        if (stepX > 0 || stepY > 0){
            move = 1;
        }else {
            move = -1;
        }
        while (oldX+stepX != getX() || oldY+stepY != getY()){
            if (oldX+stepX != getX() && oldY+stepY != getY()){
                super.setBounds(getX()+move, getY()+move, width, height);
                repaint();
            }else if (oldX+stepX != getX()){
                super.setBounds(getX()+move, getY(), width, height);
                repaint();
            }if (oldY+stepY != getY()){
                super.setBounds(getX(), getY()+move, width, height);
                repaint();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(hero, 0, 0, width, height, this);
    }

    public void moveHero() {
        while (!gameEnd) {
            if (isGoRight()) {
                moveHero(10, 0);

            } else if (isGoLeft()) {
                moveHero(-10, 0);

            } else if (isGoUp()) {
                moveHero(0, -10);

            } else if (isGoDown()) {
                moveHero(0, 10);

            } else {

            }
        }
    }

    public boolean isGoRight() {
        synchronized (syncObject) {
            return goRight;
        }
    }

    public void setGoRight(boolean goRight) {
        synchronized (syncObject) {
            this.goRight = goRight;
        }
    }

    public boolean isGoLeft() {
        synchronized (syncObject) {
            return goLeft;
        }
    }

    public void setGoLeft(boolean goLeft) {
        synchronized (syncObject) {
            this.goLeft = goLeft;
        }
    }

    public boolean isGoUp() {
        synchronized (syncObject) {
            return goUp;
        }
    }

    public void setGoUp(boolean goUp) {
        synchronized (syncObject) {
            this.goUp = goUp;
        }
    }

    public boolean isGoDown() {
        synchronized (syncObject) {
            return goDown;
        }
    }

    public void setGoDown(boolean goDown) {
        synchronized (syncObject) {
            this.goDown = goDown;
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}