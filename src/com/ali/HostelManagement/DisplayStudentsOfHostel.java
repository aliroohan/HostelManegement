package com.ali.HostelManagement;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayStudentsOfHostel extends JFrame {
    JTable table;
    JLabel title;
    JLabel hostelId;
    JTextField hostelIdField;
    JButton search;

    public static void main(String[] args) {
        new DisplayStudentsOfHostel().setVisible(true);
    }

    public DisplayStudentsOfHostel() {
        setBounds(600, 200, 850, 570);
        setTitle("Students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        title = new JLabel("Students");
        title.setBounds(400, 10, 100, 30);
        add(title);

        hostelId = new JLabel("Hostel Id");
        hostelId.setBounds(30, 50, 100, 30);
        add(hostelId);

        hostelIdField = new JTextField();
        hostelIdField.setBounds(150, 50, 150, 30);
        add(hostelIdField);

        search = new JButton("Search");
        search.setBounds(50, 100, 120, 30);
        add(search);

        search.addActionListener(e -> {
            displayStudents();
        });

        JButton home = new JButton("Go to Home");
        home.setBounds(200, 100, 120, 30);
        add(home);
        home.addActionListener(e -> {
            new Home().setVisible(true);
            setVisible(false);
        });
    }

    public void displayStudents() {
        String[] columnsNames = {"Student Id", "Name", "Age", "Gender", "Contact", "Room Number", "Hostel Id" };
        HostelManager hostelManager = new HostelManager();
        Hostel hostel = hostelManager.searchHostel(hostelIdField.getText());
        if (hostel == null) {
            JOptionPane.showMessageDialog(null, "Hostel not found");
            return;
        }
        ArrayList<Student> students = hostel.getStudents();
        Student[] s = new Student[students.size()];
        String[][] data = new String[s.length][7];
        for (int i = 0; i < s.length; i++) {
            data[i][0] = students.get(i).getStudentID();
            data[i][1] = students.get(i).getName();
            data[i][2] = String.valueOf(students.get(i).getAge());
            data[i][3] = students.get(i).getGender();
            data[i][4] = students.get(i).getContactNumber();
            data[i][5] = students.get(i).getRoomNumber() + "";
            data[i][6] = hostelManager.searchHostelByStudentID(students.get(i).getStudentID()).getHostelId();
        }

        table = new JTable(data, columnsNames);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 160, 850, 500);
        add(pane);
    }
}
