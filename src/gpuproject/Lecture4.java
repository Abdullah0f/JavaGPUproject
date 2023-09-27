package gpuproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lecture4 extends JFrame {
    // create 5 button on left right top bottom center
    JButton left = new JButton("left");
    JButton right = new JButton("right");
    JButton center = new JButton("center");
    JButton top = new JButton("top");
    JButton bottom = new JButton("bottom");
    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);

    public Lecture4() {
        setLayout(flowLayout);
        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerComponents();
    }

    private void registerComponents() {
        add(left);
        add(top);
        add(center);
        add(bottom);
        add(right);
        ButtonEvent buttonEvent = new ButtonEvent();
        left.addActionListener(buttonEvent);
        right.addActionListener(buttonEvent);
        top.addActionListener(buttonEvent);
        bottom.addActionListener(buttonEvent);
        center.addActionListener(buttonEvent);
    }

    // inner class to handle events
    private class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == left) {
                flowLayout.setAlignment(FlowLayout.LEFT);
                flowLayout.layoutContainer(getContentPane());
            }
            if (e.getSource() == right) {
                flowLayout.setAlignment(FlowLayout.RIGHT);
                flowLayout.layoutContainer(getContentPane());
            }
            if (e.getSource() == center) {
                flowLayout.setAlignment(FlowLayout.CENTER);
                flowLayout.layoutContainer(getContentPane());
            }
        }
    }
}
