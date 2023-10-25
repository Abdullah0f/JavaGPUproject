package gpuproject;

import java.awt.BorderLayout;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.event.*;

public class lec8_slider extends JPanel {
    // create a slider
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
    int ovalDim = 100;
    int transalteX = 0;

    public lec8_slider() {
        setLayout(new BorderLayout());
        // add slider
        add(slider, BorderLayout.SOUTH);

        // set slider properties
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // add listener using anonymous class
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // change font size of label
                // change oval size
                ovalDim = slider.getValue() * 2;
                transalteX = slider.getValue();
                repaint();
            }
        });
    }

    // paint component
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(transalteX, 0);
        g2d.drawOval(0, 0, ovalDim, ovalDim);
        // draw a square
        g2d.drawRect(0, ovalDim, ovalDim, ovalDim);
        // reset so panel dosnt effect
        g2d.translate(-transalteX, 0);
    }
}
