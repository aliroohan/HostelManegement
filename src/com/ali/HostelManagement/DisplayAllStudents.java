package com.ali.HostelManagement;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayAllStudents extends JFrame {
    JTable table;
    JLabel title;
    JButton home;


    public static void main(String[] args) {
        new DisplayAllStudents().setVisible(true);
    }

    public DisplayAllStudents() {
        setBounds(600, 200, 850, 570);
        setTitle("Students");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setLocationRelativeTo(null);

        title = new JLabel("Students");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        title.setBounds(375, 10, 100, 30);
        add(title);

        String[] columnsNames = {"Student Id", "Name", "Age", "Gender", "Contact", "Room Number", "Hostel Id" };
        HostelManager hostelManager = new HostelManager();
        ArrayList<Hostel> hostels = hostelManager.getHostels();
        ArrayList<Student> students = new ArrayList<Student>();
        for (Hostel hostel : hostels) {
            students.addAll(hostel.getStudents());
        }
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
        pane.setBounds(0, 70, 850, 500);
        add(pane);

        home = new JButton("Go to Home");
        home.setBounds(700, 20, 120, 30);
        add(home);
        home.addActionListener(e -> {
            new Home().setVisible(true);
            setVisible(false);
        });
    }
}
