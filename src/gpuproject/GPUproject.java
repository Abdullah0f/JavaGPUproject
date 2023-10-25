/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpuproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        JFrame myf = new JFrame();
        JPanel graph2p1 = new JPanel();
        lec7_line p2 = new lec7_line();
        p2.setPreferredSize(new Dimension(400, 400));
        graph2p1.add(p2);
        Lec7_star p3 = new Lec7_star();
        p3.setPreferredSize(new Dimension(400, 400));
        graph2p1.add(p3);
        Lec7_star2 p4 = new Lec7_star2();
        p4.setPreferredSize(new Dimension(400, 400));
        graph2p1.setPreferredSize(new Dimension(800, 800));
        myf.add(p4, BorderLayout.CENTER);
        myf.add(p2, BorderLayout.EAST);
        myf.add(p3, BorderLayout.WEST);
        myf.setVisible(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        myf.setLocation(kit.getScreenSize().width / 4, kit.getScreenSize().height / 4);
        myf.pack(); // what is pack() do? a: it will set the size of the frame to the
        // size of the
        // panel
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
