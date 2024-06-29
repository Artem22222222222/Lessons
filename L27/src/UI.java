import javax.swing.*;

public class UI {
     Controler controler;
     JFrame mainFrame;
     JButton button1;
     JPanel player;
    public UI(Controler controler) {
        this.controler = controler;
        mainFrame = new JFrame("Гра");
        mainFrame.setBounds(250, 10, 650, 550);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        player = new JPanel();
        button1 = new JButton("Персонаж");
        button1.setBounds(300,300,100,100);
        player.add(button1);
        player.setLayout(null);
        mainFrame.add(player);
        player.setVisible(true);
    }
}
