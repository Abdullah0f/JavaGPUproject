package gpuproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lecture4_4 extends JFrame {
    private JButton btn1 = new JButton("");
    private JButton btn2 = new JButton("");
    private JButton btn3 = new JButton("");
    private JButton btn4 = new JButton("");
    private JButton btn5 = new JButton("");
    private JButton btn6 = new JButton("");
    private JButton btn7 = new JButton("");
    private JButton btn8 = new JButton("");
    private JButton btn9 = new JButton("");
    private GridLayout gridLayout = new GridLayout(3, 3); // Tic Tac Toe has a 3x3 grid
    private char currentPlayer = 'X'; // We start with player X

    public Lecture4_4() {
        setLayout(gridLayout);
        setSize(500, 500);
        setLocation(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerComponents();
    }

    private void registerComponents() {
        ButtonEvent buttonEvent = new ButtonEvent();
        btn1.addActionListener(buttonEvent);
        btn2.addActionListener(buttonEvent);
        btn3.addActionListener(buttonEvent);
        btn4.addActionListener(buttonEvent);
        btn5.addActionListener(buttonEvent);
        btn6.addActionListener(buttonEvent);
        btn7.addActionListener(buttonEvent);
        btn8.addActionListener(buttonEvent);
        btn9.addActionListener(buttonEvent);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);

    }

    // inner class to handle events
    private class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals("")) { // Only allow to mark an empty cell
                clickedButton.setText(String.valueOf(currentPlayer));
                togglePlayer(); // Switch to the other player
            }
        }
    }

    private void togglePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
