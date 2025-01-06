import javax.swing.*;
import java.awt.*;

public class UI extends JFrame implements IUI{
    Controller c ;
    JButton b;
    UI(Controller c){
        this.c=c;
        setTitle("new classwork.UI");
        setSize(500, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b= new JButton(
                "OK"
        );
        b.addActionListener(c);
        b.setBounds(10,10,10,10);
        add(b);
        setVisible(true);
    }

    @Override
    public void print(String s) {
        b.setText(s);


    }
}
