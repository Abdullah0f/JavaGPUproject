package gpuproject;

import javax.swing.JPanel;
import java.awt.Color;

public class Lecture6 extends JPanel {
    public Lecture6() {
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        // draw a rectangle
        g.drawRect(0, 0, 100, 100);
        // draw a filled rectangle
        g.fillRect(0, 100, 100, 100);
        // draw a oval
        g.setColor(Color.BLUE);
        g.drawOval(0, 200, 100, 100);
        // draw a filled oval
        g.fillOval(0, 300, 100, 100);
        // clear rectangle inside the oval
        g.clearRect(25, 325, 50, 50);

        // draw a line
        g.setColor(Color.BLACK);
        g.drawLine(0, 400, 100, 500);

        // oval
        g.setColor(Color.GREEN);
        g.drawOval(100, 0, 150, 100);

        // filled oval
        g.setColor(Color.ORANGE);
        g.fillOval(100, 100, 150, 100);

        // 3d rectangle
        g.setColor(Color.PINK);
        g.draw3DRect(100, 200, 150, 100, true);

        // string
        g.setColor(Color.MAGENTA);
        g.drawString("hello", 300, 100);
    }
}
