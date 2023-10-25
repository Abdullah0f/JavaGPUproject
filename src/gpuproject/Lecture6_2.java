package gpuproject;

import java.awt.Color;

import javax.swing.JPanel;

public class Lecture6_2 extends JPanel {

    // paint component
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 0, 600);
        g.setColor(Color.BLUE);
        g.fillPolygon(new int[] { 0, 100, 200, 300 }, new int[] { 0, 300, 200, 100 }, 4);
    }
}
