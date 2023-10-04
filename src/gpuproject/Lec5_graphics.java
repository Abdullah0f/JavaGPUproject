package gpuproject;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class Lec5_graphics extends JPanel {
    Color x = Color.WHITE;
    JButton b = new JButton("choose color");

    public Lec5_graphics() {
        setLayout(new BorderLayout());
        b.setFont(new Font("Serif", Font.ITALIC, 25));

        add(b, BorderLayout.SOUTH);
        b.addActionListener(e -> {
            x = JColorChooser.showDialog(this, "Pick a color", x);
            setBackground(x);
            repaint(); // this is important to call paintComponent again to change its colors
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color clr = new Color(12, 100, 200);
        g.setColor(Color.BLACK);
        g.drawRect(0, 100, 200, 100);
        g.drawString("hello", 100, 150);
        g.setColor(new Color(0, 0, 255));
        g.fillRect(0, 200, 200, 100);
        g.setColor(new Color(0.5f, 1f, 0.3f, 0.9f));
        g.drawRect(0, 300, 200, 100);
        g.setColor(new Color(clr.getRed(), clr.getGreen(), clr.getBlue()));
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("hello" + g.getColor(), 100, 350);
        g.setColor(Color.ORANGE);
        g.fillRect(0, 400, 200, 100);
    }
}
