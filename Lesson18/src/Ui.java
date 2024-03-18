import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui extends JFrame implements ActionListener {
    private JLabel l = new JLabel("0");
    private int count = 0;
    int Stop = 0;
    Ui(){
        setSize(700, 500);
        GridLayout Layout = new GridLayout(5,3);
        
        JPanel elements = new JPanel();

        JButton b = new JButton("Start");
        elements.add(b);
        b.addActionListener(this);

        JButton b1 = new JButton("Stop");
        elements.add(b1);
        b1.addActionListener(this);

        elements.add(l);

        add(elements);

        elements.setLayout(Layout);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        HardTasks task1 = new HardTasks();
        switch (b.getText()){
            case "Start":
                 Stop = 0;
                 task1.start();
                 break;
            case "Stop":
                Stop = 1;
                break;
        }
    }
    class HardTasks extends Thread{
        @Override
        public void run() {
            while (true){
                if (Stop == 1){
                    return;
                }
                l.setText(String.valueOf(count));
                count++;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
