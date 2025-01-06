import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {
    private Image background;
    private boolean isGoRight = false;
    private boolean isGoRightEver = false;
    private int x = 0;
    private int y = 0;

    public Background() {
        try {
            background = ImageIO.read(new File("src/background2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, x, y, null);
    }

    public void moveRight(){
        while (true) {
            if (isGoRight()) {
                if (x < -4500) {
                    x = -10;

                } else {
                    x -= 50;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            repaint();
        }
    }

    public boolean isGoRight() {
        return isGoRight;
    }

    public void setGoRight(boolean goRight) {
        isGoRight = goRight;
    }

    public boolean isGoRightEver() {
        return isGoRightEver;
    }

    public void setGoRightEver(boolean goRightEver) {
        isGoRightEver = goRightEver;
    }
}