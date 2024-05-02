import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewButton extends JButton {
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
        System.out.println(1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cat, x, y, ui.getHero());
        System.out.println(2);
    }

    public void moveRight(){
        System.out.println(3);
        while (true) {
            System.out.println(goRight);
            if (goRight) {
                if (x < -545) {
                    x = -10;
                    repaint();
                    System.out.println(6);
                } else {
                    x -= 300;
                    repaint();
                    System.out.println(5);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(4);
            }else {
                x=-10;
            }
        }

    }

    public boolean isGoRight() {
        return goRight;
    }

    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    public boolean isGoRightEver() {
        return goRightEver;
    }

    public void setGoRightEver(boolean goRightEver) {
        this.goRightEver = goRightEver;
    }
}
