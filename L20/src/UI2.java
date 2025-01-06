import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class UI2 extends JFrame implements MouseListener {
    private Random random = new Random();
    ArrayList<CostomButton> buttons = new ArrayList<>();

    UI2() {
        setSize(800, 600);
        setLayout(null);

        setVisible(true);
        addMouseListener(this);

    }



    private void moveButton(CostomButton button) {
        int x = button.getX();
        int y = button.getY();
        int width = button.getWidth();
        int height = button.getHeight();

        int stepx = button.getStepX();
        int stepy = button.getStepY();


        while (true) {

            if (x < 0 || x>800-width)
                stepx*=-1;

            if (y < 0 || y>600-height)
                stepy*=-1;
            x+=stepx;
            y+=stepy;

            button.setBounds(x, y, button.getWidth(), button.getHeight());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        buttons.add(new CostomButton(random.nextInt(10)-5,random.nextInt(10)-5));
        buttons.getLast().setBounds(e.getX(),e.getY(),50,50);
        add(buttons.getLast());
        Thread thread = new Thread(() ->

                moveButton(buttons.getLast()));
        thread.start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



