/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpuproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginForm extends JFrame {
    JLabel userLabel = new JLabel("username");
    JLabel passLabel = new JLabel("password");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");
    JCheckBox darkModeCheckBox = new JCheckBox("dark mode");
    
    public LoginForm() {
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        registerComponents();
    }
    // add components function
    private void registerComponents(){
        this.add(userLabel);
        this.add(passLabel);
        this.add(userField);
        this.add(passField);
        this.add(loginButton);
        this.add(resetButton);
        this.add(darkModeCheckBox);
        setBounds();
        registerEvents();
    }
    class LoginEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if(username.isEmpty() || password.isEmpty())
                showMessage("Please fill all fields");
            else{
            if(username.equals("ali") && password.equals("123")){
                showMessage("Welcome");
            }else{
                showMessage("Login Failed");
            }
        }
        }
    }
    private void registerEvents(){
        resetButton.addActionListener(e -> reset());
        loginButton.addActionListener(new LoginEvent());
        darkModeCheckBox.addActionListener(e -> darkMode());
        userField.addActionListener(e -> onType());
    }
    private void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    private void reset(){
        userField.setText("");
        passField.setText("");
    }
    private void onType(){
        // when user type in textField, this method will be called
        // when use write "dark" in userField, darkModeCheckBox will be selected
        String username = userField.getText();
        if(username.equals("dark")){
            darkModeCheckBox.setSelected(true);
            darkMode();
        }
        else if(username.equals("light")){
            darkModeCheckBox.setSelected(false);
            darkMode();
        }
    }
    private void darkMode(){
        if(darkModeCheckBox.isSelected()){
            this.getContentPane().setBackground(Color.BLACK);
            this.darkModeCheckBox.setForeground(Color.WHITE);
            this.darkModeCheckBox.setBackground(Color.BLACK);
            this.userLabel.setForeground(Color.WHITE);
            this.passLabel.setForeground(Color.WHITE);
        }else{
            this.getContentPane().setBackground(Color.WHITE);
            this.darkModeCheckBox.setForeground(Color.BLACK);
            this.darkModeCheckBox.setBackground(Color.WHITE);
            this.userLabel.setForeground(Color.BLACK);
            this.passLabel.setForeground(Color.BLACK);
        }
    }
    private void setBounds(){
        userLabel.setBounds(10, 20, 80, 25);
        passLabel.setBounds(10, 50, 80, 25);
        userField.setBounds(100, 20, 165, 25);
        passField.setBounds(100, 50, 165, 25);
        loginButton.setBounds(10, 80, 80, 25);
        resetButton.setBounds(180, 80, 80, 25);
        darkModeCheckBox.setBounds(10, 110, 100, 25);
    }

    public static void main(String[] args) {
    }
    
}
