import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ui extends JFrame implements ActionListener, MouseMotionListener {
    private int oldX;
    private int oldY;
    private boolean iseraser = false;
    Color a = Color.BLACK;
    private JPanel a1 = new JPanel();
    Ui() {
        setSize(500, 700);
        a1.setLayout(null);
        setBackground(Color.WHITE);
        addMouseMotionListener(this);
        JButton eraser = new JButton("eraser");
        eraser.addActionListener(this);
        eraser.setBounds(50, 50, 100, 100);
        a1.add(eraser);
        JButton colorBlack = new JButton("colorBlack");
        colorBlack.addActionListener(this);
        colorBlack.setBounds(200, 50, 100, 100);
        a1.add(colorBlack);

        JButton colorRed = new JButton("colorRed");
        colorRed.addActionListener(this);
        colorRed.setBounds(350, 50, 100, 100);
        a1.add(colorRed);

        add(a1);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        switch (b.getText()){
            case "eraser":
                a = Color.WHITE;
                iseraser = true;
                break;
            case "colorBlack":
                a = Color.BLACK;
                iseraser = false;
                break;
            case  "colorRed":
                a = Color.red;
                iseraser = false;
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(a);
        if (iseraser & e.getY() >= 200) {
            g.fillRect(e.getX(), e.getY(), 10, 10);
            oldX = e.getX();
            oldY = e.getY();
        }else if (e.getY() >= 200){
            g.drawLine(oldX, oldY, e.getX(), e.getY());
            oldX = e.getX();
            oldY = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }
//    private void setVisible(){
//        add(eraser)
//    }
}
