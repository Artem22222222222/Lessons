import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewButton extends JButton {

    private final Object syncObject = new Object();
    private Image cat;
    private UI ui;
    private boolean goRight = false;
    private boolean goRightEver = false;
    private int x = -10;
    private int y = -330;
    public ViewButton(UI ui) {
        this.ui = ui;
        try {
            cat = ImageIO.read(new File("src/cat.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cat, x, y, ui.getHero());

    }

    public void moveRight(){
        while (true) {
            if (isGoRight()) {
                if (x < -545) {
                    x = -10;

                } else {
                    x -= 300;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }else {
                x=-10;
            }
            repaint();
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

    public boolean isGoRightEver() {
        return goRightEver;
    }

    public void setGoRightEver(boolean goRightEver) {
        this.goRightEver = goRightEver;
    }
}
