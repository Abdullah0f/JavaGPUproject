package gpuproject;

import java.awt.*;
import javax.swing.JPanel;

public class lec7_line extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.YELLOW);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        g.drawLine(0, 0, 400, 400);
        g.drawLine(400, 0, 0, 400);

    }

}