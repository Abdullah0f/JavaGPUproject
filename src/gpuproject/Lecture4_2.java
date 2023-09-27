package gpuproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lecture4_2 extends JFrame {
    // create 5 button on left right top bottom center
    JButton first = new JButton("first");
    JButton second = new JButton("second");
    JButton third = new JButton("third");
    JButton fourth = new JButton("fourth");
    JButton fifth = new JButton("fifth");
    BorderLayout borderLayout = new BorderLayout();

    public Lecture4_2() {
        setLayout(borderLayout);
        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerComponents();
    }

    private void registerComponents() {
        add(first, BorderLayout.CENTER);
        add(second, BorderLayout.NORTH);
        add(third, BorderLayout.SOUTH);
        add(fourth, BorderLayout.EAST);
        add(fifth, BorderLayout.WEST);
        // hide all buttons except first
        second.setVisible(false);
        third.setVisible(false);
        fourth.setVisible(false);
        fifth.setVisible(false);

        ButtonEvent buttonEvent = new ButtonEvent();
        first.addActionListener(buttonEvent);
        second.addActionListener(buttonEvent);
        third.addActionListener(buttonEvent);
        fourth.addActionListener(buttonEvent);
        fifth.addActionListener(buttonEvent);
    }

    // inner class to handle events
    private class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // when u click on first button it hides and show second button
            if (e.getSource() == first) {
                first.setVisible(false);
                second.setVisible(true);
            }
            if (e.getSource() == second) {
                second.setVisible(false);
                third.setVisible(true);
            }
            if (e.getSource() == third) {
                third.setVisible(false);
                fourth.setVisible(true);
            }
            if (e.getSource() == fourth) {
                fourth.setVisible(false);
                fifth.setVisible(true);
            }
            if (e.getSource() == fifth) {
                fifth.setVisible(false);
                first.setVisible(true);
            }
        }
    }
}
