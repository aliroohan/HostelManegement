package com.ali.HostelManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStudent extends JFrame{
    public static void main(String[] args) {
        new SearchStudent().setVisible(true);
    }

    JTextField studentId;

    public SearchStudent(){
        setBounds(600, 200, 400, 600);
        setTitle("Search Student");
        setLayout(null);

        JLabel title = new JLabel("Search Student");
        title.setBounds(100, 10, 200, 30);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        add(title);

        JLabel l1 = new JLabel("Student Id");
        l1.setBounds(30, 50, 100, 30);
        add(l1);

        studentId = new JTextField();
        studentId.setBounds(150, 50, 150, 30);
        add(studentId);

        JButton search = new JButton("Search");
        search.setBounds(100, 100, 100, 30);
        add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HostelManager hostelManager = new HostelManager();
                Student student = hostelManager.searchStudent(studentId.getText());
                String s = "Student Id:\t" + student.getStudentID() + "\nStudent Name:\t" + student.getName() + "\nAge:\t" + student.getAge() + "\nGender:\t" + student.getGender() + "\nContact:\t" + student.getContactNumber() + "\nRoom No:\t" + student.getRoomNumber();
                if (student != null) {
                    JOptionPane.showMessageDialog(null, s, "Student Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found");
                }
            }
        });
    }
}
