/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpuproject;

import javax.swing.JFrame;

public class GPUproject extends JFrame {

    public GPUproject() {
        setLayout(null);
        Lecture6 l = new Lecture6();
        l.setBounds(0, 0, 400, 600);
        add(l);
        Lecture6_2 l2 = new Lecture6_2();
        l2.setBounds(400, 0, 400, 600);
        add(l2);
    }
    public static void main(String[] args) {
        GPUproject x = new GPUproject();
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setSize(800, 600);
        x.setVisible(true);
    }
    
}
