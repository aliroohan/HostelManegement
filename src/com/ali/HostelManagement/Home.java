package com.ali.HostelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton addHostel, removeHostel, displayHostel, addStudent, removeStudent, editStudent, searchStudent, displayStudent;

    Home() {

        setLayout(null);
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home background.PNG"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Hostel Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        addHostel = new JButton("Add Hostel");
        addHostel.setBounds(50, 80, 150, 40);
        addHostel.addActionListener(this);
        image.add(addHostel);


        removeHostel = new JButton("Remove Hostel");
        removeHostel.setBounds(50, 130, 150, 40);
        removeHostel.addActionListener(this);
        image.add(removeHostel);


        displayHostel = new JButton("Display Hostels");
        displayHostel.setBounds(50, 180, 150, 40);
        displayHostel.addActionListener(this);
        image.add(displayHostel);

        addStudent = new JButton("Add Student");
        addStudent.setBounds(50, 230, 150, 40);
        addStudent.addActionListener(this);
        image.add(addStudent);

        removeStudent = new JButton("Remove Student");
        removeStudent.setBounds(50, 280, 150, 40);
        removeStudent.addActionListener(this);
        image.add(removeStudent);

        searchStudent = new JButton("Search Student");
        searchStudent.setBounds(50, 330, 150, 40);
        searchStudent.addActionListener(this);
        image.add(searchStudent);

        displayStudent = new JButton("Display Students");
        displayStudent.setBounds(50, 380, 150, 40);
        displayStudent.addActionListener(this);
        image.add(displayStudent);



        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addHostel) {
            setVisible(false);
            new AddHostel().setVisible(true);
        } else if (ae.getSource() == removeHostel) {
            setVisible(false);
            new RemoveHostel().setVisible(true);
        } else if (ae.getSource() == displayHostel) {
            setVisible(false);
            new DisplayHostels().setVisible(true);
        } else if (ae.getSource() == addStudent){
            setVisible(false);
            new AddStudent().setVisible(true);
        } else if (ae.getSource() == removeStudent){
            setVisible(false);
            new RemoveStudent().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
