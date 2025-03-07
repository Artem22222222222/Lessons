package org.example;

import javax.swing.*;
import java.awt.*;

public class Hitboxindicator extends JPanel {
    public Hitboxindicator() {
        setPreferredSize(new Dimension(500, 500)); // Встановлюємо розмір панелі
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        HitboxObject hitboxObject = new HitboxObject(250, 250, 5);
        for (int x = 0; x < 500; x++) {
            for (int y = 0; y < 500; y++) {
                if (hitboxObject.calculate(x, y)){
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }
}