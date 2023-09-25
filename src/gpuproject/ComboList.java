package gpuproject;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class ComboList extends JFrame {
    JLabel l1 = new JLabel();
    String path = "C:\\Users\\442050471\\Documents\\NetBeansProjects\\GPUproject\\src\\gpuproject";
    // create array of icons
    ImageIcon[] icons = {
            new ImageIcon(path + "/apple.jpg"),
            new ImageIcon(path + "/banana.jpg"),
            new ImageIcon(path + "/orange.jpg"),
            new ImageIcon(path + "/strawberry.png"),
            new ImageIcon(path +  "/grape.jpg")
    };
    JLabel displayName = new JLabel();
    String[] names = { "apple", "banana", "orange", "strawberry", "grape" };
    JComboBox<String> combo = new JComboBox<>(names);

    String[] colors = {"Black", "Blue", "White", "Red", "Green", "Yellow"};
    Color[] color = {Color.BLACK, Color.BLUE, Color.WHITE, Color.RED, Color.GREEN, Color.YELLOW};
    JScrollPane scrollPane = new JScrollPane();
    JList<String> list = new JList<>(colors);


    public ComboList() {
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        registerComponents();
    }
    private void registerComponents() {
        l1.setIcon(icons[0]);
        add(l1);
        add(displayName);
        add(combo);
        add(scrollPane);
        scrollPane.setViewportView(list);
        list.setVisibleRowCount(3);
        list.addListSelectionListener(new ListSelected());
        // use handler class not his approach, what is handler class? idk dr said it
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = combo.getSelectedIndex();
                l1.setIcon(icons[index]);
                displayName.setText(names[index]);
            }
        });
    }
    class ListSelected implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int index = list.getSelectedIndex();
            getContentPane().setBackground(color[index]);
        }
    }
}
