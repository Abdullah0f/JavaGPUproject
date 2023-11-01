package gpuproject;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class lec9_menu extends JFrame {
    // add text
    JTextArea text = new JTextArea("Hello World");

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
    JMenuItem print = new JMenuItem("print");
    // add as checkbox
    JCheckBoxMenuItem item5 = new JCheckBoxMenuItem("Dark Mode");

    // create submenu
    JMenu submenu = new JMenu("Color");
    // add submenu to menu
    JMenuItem item6 = new JMenuItem("Red");
    JMenuItem item7 = new JMenuItem("Blue");
    JMenuItem item8 = new JMenuItem("Green");
    JMenuItem fontsize = new JMenuItem("Set Font Size");
    JMenuItem fontsizeSlider = new JMenuItem("Set Font Size (slider)");
    JMenuItem fontcolor = new JMenuItem("Font Color");

    // create submenu

    JMenu fontstyle = new JMenu("Font Style");
    // create submenu items
    // style
    // make it radio button to select only one
    JMenuItem fontstyle1 = new JRadioButtonMenuItem("Bold");
    JMenuItem fontstyle2 = new JRadioButtonMenuItem("Italic");

    public lec9_menu() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addEvents();
        // add menu to menubar
        menubar.add(menu);
        menu.setMnemonic('F');
        menubar.add(menu2);
        menu2.setMnemonic('R');
        menubar.add(menu3);
        menu3.setMnemonic('M');
        menubar.add(menu4);
        menu4.setMnemonic('H');

        // add menu items to menu
        menu.add(item2);
        menu.add(item1);
        menu.add(item3);
        menu.add(item4);
        menu.add(print);
        menu.add(item5);
        // add to menu2
        submenu.add(item6);
        submenu.add(item7);
        submenu.add(item8);

        fontstyle.add(fontstyle1);
        fontstyle.add(fontstyle2);

        menu3.add(fontsize);
        menu3.add(fontstyle);
        menu3.add(fontcolor);
        menu3.add(submenu);
        menu3.add(fontsizeSlider);

        // add menubar to frame
        setJMenuBar(menubar);
        text.setLineWrap(true);
        add(new JScrollPane(text));
        setVisible(true);

    }

    private void addEvents() {

        fontsize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter font size:");
                int size = Integer.parseInt(input);
                getContentPane().setFont(new java.awt.Font("Arial",
                        getContentPane().getFont().getStyle(), size));
                text.setFont(new java.awt.Font("Arial",
                        getContentPane().getFont().getStyle(), size));
            }
        });

        item4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // add action to color submenu
        item6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.RED);
                text.setBackground(java.awt.Color.RED);
            }
        });
        item7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.BLUE);
                text.setBackground(java.awt.Color.BLUE);
            }
        });
        item8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(java.awt.Color.GREEN);
                text.setBackground(java.awt.Color.GREEN);
            }
        });

        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // print the text area content
                try {
                    text.print();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // open file
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
            }
        });

        // add action to font size submenu

        // // add action to font weight submenu
        // font style is radio button so we need to add action to each item
        fontstyle1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setFont(new java.awt.Font("Arial",
                        java.awt.Font.BOLD, getContentPane().getFont()
                                .getSize()));
                text.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD,
                        getContentPane().getFont().getSize()));
                fontstyle2.setSelected(false);
            }
        });
        fontstyle2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getContentPane().setFont(new java.awt.Font("Arial",
                        java.awt.Font.PLAIN, getContentPane().getFont()
                                .getSize()));
                text.setFont(new java.awt.Font("Arial", java.awt.Font.ITALIC,
                        getContentPane().getFont().getSize()));
                fontstyle1.setSelected(false);
            }
        });

        // // add action to font color submenu
        fontcolor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a color",
                        Color.BLACK);
                getContentPane().setForeground(color);
                text.setForeground(color);
            }
        });

        fontsizeSlider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // create pane that have a slider that changes font
                // size
                JPanel panel = new JPanel();
                JSlider slider = new JSlider(0, 100);
                slider.setMajorTickSpacing(10);
                slider.setMinorTickSpacing(1);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);
                panel.add(slider);
                JOptionPane.showMessageDialog(null, panel);
                getContentPane().setFont(new java.awt.Font("Arial",
                        getContentPane().getFont().getStyle(), slider
                                .getValue()));
                text.setFont(new java.awt.Font("Arial",
                        getContentPane().getFont().getStyle(), slider
                                .getValue()));
            }
        });
    }

}
