import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener{
    private JLabel l = new JLabel("0");
    private String a = "";
    private int result = 0;
    private  boolean isNotResultChange = true;
    private String sign = "";
    private boolean cleaner = false;
    UI(){
        setSize(700,500);
        GridLayout Layout = new GridLayout(5,3);

        JPanel elements = new JPanel();

        elements.setLayout(Layout);



        JButton b = new JButton("+");
        elements.add(b);

        JButton b1 = new JButton("-");
        elements.add(b1);

        JButton b2 = new JButton("*");
        elements.add(b2);

        JButton b3 = new JButton("/");
        elements.add(b3);

        JButton b4 = new JButton("1");
        elements.add(b4);

        JButton b5 = new JButton("2");
        elements.add(b5);

        JButton b6 = new JButton("3");
        elements.add(b6);

        JButton b7 = new JButton("4");
        elements.add(b7);

        JButton b8 = new JButton("5");
        elements.add(b8);

        JButton b9 = new JButton("6");
        elements.add(b9);

        JButton b10 = new JButton("7");
        elements.add(b10);

        JButton b11 = new JButton("8");
        elements.add(b11);

        JButton b12 = new JButton("9");
        elements.add(b12);

        JButton b13 = new JButton("0");
        elements.add(b13);

        JButton b14 = new JButton("c");
        elements.add(b14);

        JButton b15 = new JButton("=");
        elements.add(b15);



        add(elements);

        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);

        elements.add(l);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (l.getText().equals("0") || cleaner){
            l.setText("");
            a = "";
        }
        String buttonText = b.getText();
        switch (buttonText){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                l.setText(l.getText()+buttonText);
                a += b.getText();
                cleaner = false;
                break;
            case "c":
                l.setText("0");
                result = 0;
                isNotResultChange = true;
                break;
            case "+":
                if (isNotResultChange) {
                    result += Integer.valueOf(a);
                    isNotResultChange = false;
                }
                sign = "+";
                cleaner = true;
                break;
            case "-":
                if (isNotResultChange) {
                    result += Integer.valueOf(a);
                    isNotResultChange = false;
                }
                sign = "-";
                cleaner = true;
                break;
            case "*":
                if (isNotResultChange) {
                    result += Integer.valueOf(a);
                    isNotResultChange = false;
                }
                sign = "*";
                cleaner = true;
                break;
            case "/":
                if (isNotResultChange) {
                    result += Integer.valueOf(a);
                    isNotResultChange = false;
                }
                sign = "/";
                cleaner = true;
                break;
            case "=":
                switch (sign){
                    case "+":
                        result += Integer.valueOf(a);
                        break;
                    case "-":
                        result -= Integer.valueOf(a);
                        break;
                    case "*":
                        result = Integer.valueOf(a)*result;
                        break;
                    case "/":
                        result /= Integer.valueOf(a);
                        break;
                }
                l.setText(String.valueOf(result));
                cleaner = true;
                break;
        }
    }
}

