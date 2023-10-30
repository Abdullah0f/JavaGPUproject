package gpuproject;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.JMenuBar;

public class lec9_menu extends JFrame {
    // menubar
    JMenuBar menubar = new JMenuBar();
    // menu
    JMenu menu = new JMenu("File");
    JMenu menu2 = new JMenu("Records");
    JMenu menu3 = new JMenu("Format");
    JMenu menu4 = new JMenu("Help");
    // add menu to menubar
    JMenuItem item1 = new JMenuItem("New");
    JMenuItem item2 = new JMenuItem("Open");
    JMenuItem item3 = new JMenuItem("Save");
    JMenuItem item4 = new JMenuItem("Exit");

    // add as checkbox
    JCheckBoxMenuItem item5 = new JCheckBoxMenuItem("Dark Mode");
    // create submenu
    JMenu submenu = new JMenu("Color");
    // add submenu to menu
    JMenuItem item6 = new JMenuItem("Red");
    JMenuItem item7 = new JMenuItem("Blue");
    JMenuItem item8 = new JMenuItem("Green");

    public lec9_menu() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // add menu to menubar
        menubar.add(menu);
        menu.setMnemonic('F');
        menubar.add(menu2);
        menu2.setMnemonic('R');
        menubar.add(menu3);
        menu3.setMnemonic('M');
        menubar.add(menu4);
        menu4.setMnemonic('H');

        // add action on item4 (exit) (using anonymous class)
        item4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // add action to color submenu
        item6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.RED);
            }
        });
        item7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.BLUE);
            }
        });
        item8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.GREEN);
            }
        });

        // add menu items to menu
        menu.add(item2);
        menu.add(item1);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        // add to menu2
        submenu.add(item6);
        submenu.add(item7);
        submenu.add(item8);
        menu3.add(submenu);

        // add menubar to frame
        setJMenuBar(menubar);
    }

}
