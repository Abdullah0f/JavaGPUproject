/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpuproject;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class GPUproject {
    public static void main(String[] args) {
        // create jframe since lec5_graphics extends JPanel
        JFrame f = new JFrame("Lec5_graphics");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.setVisible(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // get width of screen
        int w = kit.getScreenSize().width;
        // get height of screen
        int h = kit.getScreenSize().height;
        // set size of window
        f.setSize(w / 2, h - h / 4);
        f.add(new Lec7_star());
    }
    
}
