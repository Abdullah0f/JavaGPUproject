package gpuproject;

import javax.swing.*;
import java.awt.*;

public class Lecture3 extends JFrame {
    JPanel redPanel = new JPanel();
    JPanel yellowPanel = new JPanel();
    JPanel bluePanel = new JPanel();
    JPanel greenPanel = new JPanel();
    JPanel blackPanel = new JPanel();
    JPanel whitePanel = new JPanel();
    JButton button = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");

    public Lecture3() {
        setSize(900, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        registerComponents();
    }

    private void registerComponents() {
        redPanel.setBackground(Color.RED);
        yellowPanel.setBackground(Color.YELLOW);
        bluePanel.setBackground(Color.BLUE);
        greenPanel.setBackground(Color.GREEN);
        blackPanel.setBackground(Color.BLACK);
        whitePanel.setBackground(Color.WHITE);
        greenPanel.setPreferredSize(new Dimension(280, 100));
        redPanel.setPreferredSize(new Dimension(280, 100));
        // add(redPanel, BorderLayout.NORTH);
        // add(yellowPanel, BorderLayout.SOUTH);
        add(redPanel, BorderLayout.EAST);
        add(greenPanel, BorderLayout.WEST);
        add(whitePanel, BorderLayout.CENTER);

    }
}
