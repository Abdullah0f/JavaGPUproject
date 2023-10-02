/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpuproject;

import javax.swing.JFrame;

public class GPUproject {
    public static void main(String[] args) {
        // create jframe since lec5_graphics extends JPanel
        JFrame f = new JFrame("Lec5_graphics");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.setVisible(true);
        f.add(new Lec5_graphics());
    }
    
}
