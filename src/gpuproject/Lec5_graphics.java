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
        add(b, BorderLayout.SOUTH);
        b.addActionListener(e -> {
            x = JColorChooser.showDialog(this, "Pick a color", x);
            setBackground(x);
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 100, 200, 100);
        g.drawString("hello", 100, 150);
        g.setColor(Color.BLUE);
        g.fillRect(0, 200, 200, 100);
        g.setColor(Color.RED);
        g.drawRect(0, 300, 200, 100);
        g.drawString("hello", 100, 350);
        g.setColor(Color.GREEN);
        g.fillRect(0, 400, 200, 100);
    }
}
