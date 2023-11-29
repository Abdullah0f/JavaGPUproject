package gpuproject;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class lec11_DBQuiz extends JFrame {
    lec10_DB db = new lec10_DB();

    ResultSet rs;
    JTextField courseName = new JTextField(20);
    JTextField courseNo = new JTextField(20);
    JTextField courseCode = new JTextField(20);
    JLabel courseNameLabel = new JLabel("Course Name");
    JLabel courseNoLabel = new JLabel("Course No");
    JLabel courseCodeLabel = new JLabel("Course Code");
    // add course button
    JButton addCourse = new JButton("Add Course");

    JTextField searchName = new JTextField(20);
    JButton search = new JButton("Search");

    // next button
    JButton next = new JButton("Next");
    // previous button
    JButton previous = new JButton("Previous");
    // delete button
    JButton delete = new JButton("Delete");

    // show all records
    JButton showRecords = new JButton("Show Records");
    // add place to show records
    JTextArea records = new JTextArea();

    public lec11_DBQuiz() {
        // null layout
        setLayout(null);
        // set size
        setSize(400, 500);
        // set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();
        addEvents();
        setVisible(true);
    }

    private void initShowRecords() {
        // use getColumnNames method to get column names
        String[] columnNames = db.getColumnNames(rs);
        // print them in showRecords textarea
        for (String columnName : columnNames) {
            records.append(columnName + " | ");
        }
        records.append("\n");

    }

    private void addEvents() {
        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = courseName.getText();
                Integer no = Integer.parseInt(courseNo.getText());
                String code = courseCode.getText();
                int result;
                if (name.isEmpty() || code.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }
                // if rs is yet to be filled
                if (rs == null) {
                    String query = "INSERT INTO courses (course_no, course_name, course_code) VALUES ('" + no + "', '"
                            + name
                            + "', '" + code + "')";
                    result = db.executeUpdate(query);
                } else {
                    try {

                        rs.moveToInsertRow();
                        rs.updateInt("course_no", no);
                        rs.updateString("course_name", name);
                        rs.updateString("course_code", code);
                        rs.insertRow();
                        rs.moveToCurrentRow();
                        System.out.println("rs inserted");
                        result = 1;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        result = -1;
                    }
                }
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Course added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error adding course");
                }
            }
        });

        showRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT * FROM courses";
                records.setText("");
                try {
                    // execute query
                    rs = db.executeQuery(query);
                    initShowRecords();
                    // iterate over result set
                    while (rs.next()) {
                        // get values
                        int course_no = rs.getInt("course_no");
                        String course_name = rs.getString("course_name");
                        String course_code = rs.getString("course_code");
                        // append to text area
                        records.append(course_no + " | " + course_name + " | " + course_code + "\n");
                    }
                    // now go the first record
                    rs.first();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.next()) {
                        // get values
                        int course_no = rs.getInt("course_no");
                        String course_name = rs.getString("course_name");
                        String course_code = rs.getString("course_code");
                        // append to text area
                        courseName.setText(course_name);
                        courseNo.setText(course_no + "");
                        courseCode.setText(course_code);
                    } else {
                        JOptionPane.showMessageDialog(null, "No more records");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.previous()) {
                        // get values
                        int course_no = rs.getInt("course_no");
                        String course_name = rs.getString("course_name");
                        String course_code = rs.getString("course_code");
                        // append to text area
                        courseName.setText(course_name);
                        courseNo.setText(course_no + "");
                        courseCode.setText(course_code);
                    } else {
                        JOptionPane.showMessageDialog(null, "No more records");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    rs.deleteRow();
                    JOptionPane.showMessageDialog(null, "Record deleted");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchName.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter course name");
                    return;
                }
                String query = "SELECT * FROM courses WHERE course_code = '" + name + "'";
                try {
                    // execute query
                    rs = db.executeQuery(query);
                    // iterate over result set
                    if (rs.next()) {
                        // get values
                        int course_no = rs.getInt("course_no");
                        String course_name = rs.getString("course_name");
                        String course_code = rs.getString("course_code");
                        // append to text area
                        courseName.setText(course_name);
                        courseNo.setText(course_no + "");
                        courseCode.setText(course_code);
                    } else {
                        JOptionPane.showMessageDialog(null, "No such record");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void addComponents() {
        // add and configure components
        courseNoLabel.setBounds(10, 10, 100, 20);
        courseNo.setBounds(120, 10, 200, 20);
        courseNameLabel.setBounds(10, 40, 100, 20);
        courseName.setBounds(120, 40, 200, 20);
        courseCodeLabel.setBounds(10, 70, 100, 20);
        courseCode.setBounds(120, 70, 200, 20);
        addCourse.setBounds(10, 100, 100, 20);
        showRecords.setBounds(120, 100, 100, 20);
        search.setBounds(10, 130, 100, 20);
        searchName.setBounds(120, 130, 200, 20);
        records.setBounds(10, 160, 300, 200);
        records.setEditable(false);
        records.setBackground(Color.LIGHT_GRAY);
        next.setBounds(10, 370, 100, 20);
        previous.setBounds(120, 370, 100, 20);
        delete.setBounds(230, 370, 100, 20);

        add(next);
        add(previous);
        add(showRecords);
        add(records);
        add(courseNameLabel);
        add(courseName);
        add(courseNoLabel);
        add(courseNo);
        add(courseCodeLabel);
        add(courseCode);
        add(addCourse);
        add(delete);
        add(search);
        add(searchName);
    }
}