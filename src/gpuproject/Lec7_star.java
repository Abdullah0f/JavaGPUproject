package gpuproject;

import javax.swing.JPanel;
import java.awt.*;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lec7_star extends JPanel {
    Random r = new Random();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.pink);
        Graphics2D g2d = (Graphics2D) g;
        int x[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
        int y[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
        g2d.translate(150, 150);
        g.fillPolygon(x, y, 10);
        for (int i = 1; i <= 40; i++) {
            try {
                g2d.rotate(Math.PI / 10.0);
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                g.fillPolygon(x, y, 10);
                // sleep(40);
                repaint();
            } catch (Exception ex) {
                Logger.getLogger(Lec7_star.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

// main should be:
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