import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class UI extends JFrame implements ActionListener {
    private Random random = new Random();
    ArrayList<CostomButton> buttons = new ArrayList<>();
    static boolean notGameEnd = true;
    private JButton b = new JButton();
    private int time = 1000;

    UI() {
        setSize(800, 600);
        setLayout(null);
        b.setBounds(400,300,50,50);
        add(b);
        setVisible(true);
        Thread thread = new Thread(this::spawn);
        thread.start();
    }



    private void moveButton(CostomButton button) {
        int x = button.getX();
        int y = button.getY();

        int stepX = button.getStepX();
        int stepY = button.getStepY();

        while (button.isNotGameEnd()) {
            x+=stepX;
            y+=stepY;

            button.setBounds(x, y, button.getWidth(), button.getHeight());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        remove(button);

    }

    public void spawn() {
        while (notGameEnd) {
            int startX = random.nextInt(800);
            int startY = random.nextInt(800);
            while (b.getX() - startX <= 100 && startX - b.getX() <= 100 && b.getY() - startY <= 100 && startY - b.getY() <= 100) {
                startX = random.nextInt(800);
                startY = random.nextInt(800);
            }
            buttons.add(new CostomButton());
            buttons.getLast().addActionListener(e -> {
                CostomButton b = (CostomButton) e.getSource();
                buttons.remove(b);
                b.gameOver();
            });
            buttons.getLast().setBackground(Color.red);
            buttons.getLast().setBounds(startX, startY, 50, 50);
            buttons.getLast().setStepX((b.getX() - buttons.getLast().getX()) / 100);
            buttons.getLast().setStepY((b.getY() - buttons.getLast().getY()) / 100);
            add(buttons.getLast());
            Thread thread = new Thread(() ->

                    moveButton(buttons.getLast()));
            thread.start();
            for (int i = 0; i < buttons.size(); i++) {
                if (Math.sqrt(Math.pow(b.getX() - buttons.get(i).getX(), 2) + Math.pow(b.getY() - buttons.get(i).getY(), 2)) <= 50){
                    notGameEnd = false;
                    buttons.stream().forEach(CostomButton::gameOver);
                    win(false);
                    }
            }


            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (time > 1) {
                time--;
            }else {
                notGameEnd = false;
                win(true);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private void win(boolean win){
        JLabel l = new JLabel();
        setLayout(null);
        if (win){
            l.setText("Win!!!");
            l.setBounds(400,0,200,100);
        }else {
            l.setText("Game over!!!");
            l.setBounds(400,0,200,100);
        }
        add(l);
    }
}



