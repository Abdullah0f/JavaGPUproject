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

// lec7 main
// public static void main(String[] args) {
// JFrame myf = new JFrame();
// JPanel graph2p1 = new JPanel();
// lec7_line p2 = new lec7_line();
// p2.setPreferredSize(new Dimension(400, 400));
// graph2p1.add(p2);
// Lec7_star p3 = new Lec7_star();
// p3.setPreferredSize(new Dimension(400, 400));
// graph2p1.add(p3);
// Lec7_star2 p4 = new Lec7_star2();
// p4.setPreferredSize(new Dimension(400, 400));
// graph2p1.setPreferredSize(new Dimension(800, 800));
// myf.add(p4, BorderLayout.CENTER);
// myf.add(p2, BorderLayout.EAST);
// myf.add(p3, BorderLayout.WEST);
// myf.setVisible(true);
// Toolkit kit = Toolkit.getDefaultToolkit();
// myf.setLocation(kit.getScreenSize().width / 4, kit.getScreenSize().height /
// 4);
// myf.pack(); // what is pack() do? a: it will set the size of the frame to the
// // size of the
// // panel
// myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// }
