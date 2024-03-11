import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class UI extends JFrame implements ActionListener, MouseMotionListener {

    private JButton b = new JButton("1");
    private int oldX;
    private int oldY;
    private  int slide = 0;
    ArrayList<ArrayList<Matrix>> matrix = new ArrayList<>();
    ArrayList<Matrix> matrix2 = new ArrayList<>();
    UI(){
        for (int x = 0; x < 501; x++) {
            for (int y = 0; y < 701; y++) {
                matrix2.add(new Matrix(x, y, 0));
            }
        }
        matrix.add(matrix2);
        setSize(500,700);
        setLayout(null);
        addMouseMotionListener(this);
        JButton forward = new JButton("forward");
        forward.addActionListener(this);
        forward.setBounds(50, 50, 100, 100);
        add(forward);
        JButton back = new JButton("back");
        back.addActionListener(this);
        back.setBounds(100, 100, 100, 100);
        add(back);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics f = getGraphics();
        JButton b2 = (JButton) e.getSource();
        f.setColor(Color.blue);
        switch (b2.getText()){
            case "forward":

                if (slide+1 == matrix.size()){
                    for (int x = 0; x < 501; x++) {
                        for (int y = 0; y < 701; y++) {
                            matrix2.add(new Matrix(x, y, 0));
                        }
                    }
                    matrix.add(matrix2);
                    f.setColor(Color.white);
                    f.fillRect(0,0,500,700);
                    slide++;
                    add(b2);
                }else {
                    f.setColor(Color.black);
                    slide++;
                    for (int i = 0; i < matrix.get(slide).size(); i++){
                        if (matrix.get(slide).get(i).getColor() == 1)
                            f.fillRect(matrix.get(slide).get(i).getX(), matrix.get(slide).get(i).getY(), 1, 1);
                    }
                }
                break;
            case "back":
              if (slide > 0) {
                  slide--;
                  f.setColor(Color.white);
                  f.fillRect(0, 0, 500, 700);
                  add(b2);
                  f.setColor(Color.black);
                  for (int i = 0; i < matrix.get(slide).size(); i++) {
                      if (matrix.get(slide).get(i).getColor() == 1)
                          f.drawLine(matrix.get(slide).get(i).getX(), matrix.get(slide).get(i).getY(), matrix.get(slide).get(i).getX(), matrix.get(slide).get(i).getY());
                  }
              }
              break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.drawLine(oldX, oldY, e.getX(), e.getY());
        oldX = e.getX();
        oldY = e.getY();
        for (int i = 0; i < matrix.get(slide).size(); i++){
            if (e.getX() == matrix.get(slide).get(i).getX() & e.getY() == matrix.get(slide).get(i).getY()){
                matrix.get(slide).get(i).setColor(1);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }
}
