import javax.swing.*;
import java.awt.*;

public class FlowerDrawing extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Задаємо кольори
        g.setColor(Color.RED); // Червона для центральної частини квітки
        g.fillOval(100, 100, 100, 100); // Малюємо центральну частину квітки

        g.setColor(Color.YELLOW); // Жовта для листочків
        // Малюємо верхній листочок
        g.fillOval(75, 75, 50, 50);
        // Малюємо нижній листочок
        g.fillOval(125, 125, 50, 50);

        g.setColor(Color.PINK); // Рожева для пелюсток
        // Малюємо верхні пелюстки
        g.fillOval(75, 100, 50, 50);
        g.fillOval(125, 100, 50, 50);
        // Малюємо нижні пелюстки
        g.fillOval(75, 150, 50, 50);
        g.fillOval(125, 150, 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Малюнок квітки");
        FlowerDrawing flowerDrawing = new FlowerDrawing();
        frame.add(flowerDrawing);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
