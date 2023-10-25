package gpuproject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import static java.lang.Thread.sleep;

public class Lec7_star2 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
        int y[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };

        GeneralPath star = new GeneralPath();
        star.moveTo(x[0], y[0]);

        for (int i = 1; i < x.length; i++) {
            star.lineTo(x[i], y[i]);
        }

        star.closePath();

        g2d.translate(150, 150);

        g2d.setColor(Color.RED);

        // gradient
        g2d.setPaint(new GradientPaint(0, 0, Color.RED, 100, 100, Color.BLUE));

        g2d.fill(star);

        g2d.setColor(Color.BLACK);

        // make star rotate in its place and also change gradient
        // it should rotate and change gradient by randomngly changing using
        // Math.random()
        for (int i = 1; i <= 40; i++) {
            try {
                g2d.rotate(Math.PI / 5);
                g2d.setPaint(new GradientPaint(0, 0, new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                        (int) (Math.random() * 255)), 100, 100,
                        new Color((int) (Math.random() * 255),
                                (int) (Math.random() * 255), (int) (Math.random() * 255))));
                g2d.fillPolygon(new int[] { 0, 50, 50, 0 }, new int[] { 0, 0, 50, 50 }, 4);
                sleep(10);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
