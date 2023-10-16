package gpuproject;

import javax.swing.*;
import java.awt.*;

public class Lecture7 extends JPanel {
    public Lecture7() {
        System.out.println("Lecture7");
        // toolkit
        Toolkit kit = Toolkit.getDefaultToolkit();
        // get width of screen
        int w = kit.getScreenSize().width;
        // get height of screen
        int h = kit.getScreenSize().height;
        // set size of panel (you should apply this in the frame that this panel going
        // to be added in)
        setSize(w, h);
        // set background color
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw line
        setBackground(Color.YELLOW);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.RED);
        // draw two line as X
        g2.drawLine(0, 0, getWidth(), getHeight());
        g2.drawLine(getWidth(), 0, 0, getHeight());
    }
}
