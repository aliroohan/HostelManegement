package com.ali.HostelManagement;

import javax.swing.*;

public class AddStudent extends JFrame{
    JButton AddStudent;
    JTextField studentId;
    JTextField studentName;
    JTextField age;
    JComboBox<String> gender;
    JTextField contact;
    JTextField roomNumber;
    JTextField hostelId;
    Hostel hostel;
    HostelManager hostelManager;


    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    }

    public AddStudent() {
        setBounds(600, 200, 400, 600);
        setLayout(null);
        setTitle("Add Student");

        JLabel title = new JLabel("Add Student");
        title.setBounds(100, 10, 200, 30);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        add(title);

        JLabel l1 = new JLabel("Student Id");
        l1.setBounds(30, 50, 100, 30);
        add(l1);

        studentId = new JTextField();
        studentId.setBounds(150, 50, 150, 30);
        add(studentId);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(30, 100, 100, 30);
        add(l2);

        studentName = new JTextField();
        studentName.setBounds(150, 100, 150, 30);
        add(studentName);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(30, 150, 100, 30);
        add(l4);

        age = new JTextField();
        age.setBounds(150, 150, 150, 30);
        add(age);


        JLabel l3 = new JLabel("Gender");
        l3.setBounds(30, 200, 100, 30);
        add(l3);

        gender = new JComboBox<>(new String[]{"Male", "Female"});
        gender.setBounds(150, 200, 150, 30);
        add(gender);
        JLabel l5 = new JLabel("Contact");
        l5.setBounds(30, 250, 100, 30);
        add(l5);

        contact = new JTextField();
        contact.setBounds(150, 250, 150, 30);
        add(contact);

        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(30, 300, 100, 30);
        add(l6);

        roomNumber = new JTextField();
        roomNumber.setBounds(150, 300, 150, 30);
        add(roomNumber);

        JLabel l7 = new JLabel("Hostel Id");
        l7.setBounds(30, 350, 100, 30);
        add(l7);

        hostelId = new JTextField();
        hostelId.setBounds(150, 350, 150, 30);
        add(hostelId);

        AddStudent = new JButton("Add Student");
        AddStudent.setBackground(UIManager.getColor("Button.disabledShadow"));
        AddStudent.setForeground(UIManager.getColor("Button.disabledForeground"));

        AddStudent.setBounds(50, 410, 120, 30);
        add(AddStudent);
        AddStudent.addActionListener(e -> {
            this.setVisible(false);
            new AddStudent().setVisible(true);
            hostelManager = new HostelManager();
            hostel = hostelManager.searchHostel(hostelId.getText());
            Student student = new Student(studentId.getText(), studentName.getText(), Integer.parseInt(age.getText()), (String) gender.getSelectedItem(), contact.getText(), Integer.parseInt(roomNumber.getText()));


            if (hostel == null) {
                JOptionPane.showMessageDialog(null, "Hostel not found");
                return;
            }
            if (hostelManager.checkDuplicateStudentID(student.getStudentID())){
                JOptionPane.showMessageDialog(null, "Student with this ID already exists");
                return;
            }
            hostelManager.addStudent(student, hostel);
            JOptionPane.showMessageDialog(null, "Student added successfully");
        });
    }

}
