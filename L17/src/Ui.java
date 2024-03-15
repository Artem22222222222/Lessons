import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui extends JFrame implements ActionListener {

    JButton b = new JButton("ok");

    Ui() {
        setLayout(null);
        setSize(500, 500);
        b.addActionListener(this);
        add(b);
        b.setBounds(50, 50, 100, 200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Tasks task1 = new Tasks();
        task1.start();
    }

    class Tasks extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("he");
            }
        }
    }
}
