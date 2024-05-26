package com.ali.HostelManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHostel extends JFrame implements ActionListener {
    JButton b;
    JTextField hostelId;
    JTextField hostelName;
    JTextField hostelAddress;
    JButton homeButton;

    public static void main(String[] args) {
        new AddHostel().setVisible(true);
    }

    public AddHostel() {
        setBounds(600, 200, 850, 570);
        setTitle("Add Hostel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("Hostel Id");
        l1.setBounds(30, 50, 100, 30);
        add(l1);

        hostelId = new JTextField();
        hostelId.setBounds(150, 50, 150, 30);
        add(hostelId);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(30, 100, 100, 30);
        add(l2);

        hostelName = new JTextField();
        hostelName.setBounds(150, 100, 150, 30);
        add(hostelName);

        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 30);
        add(l3);



        hostelAddress = new JTextField();
        hostelAddress.setBounds(150, 150, 150, 30);
        add(hostelAddress);

        b = new JButton("Add Hostel");
        b.setBackground(UIManager.getColor("Button.disabledShadow"));
        b.setForeground(UIManager.getColor("Button.disabledForeground"));


        b.setBounds(50, 210, 120, 30);
        add(b);
        b.addActionListener(this);

        homeButton = new JButton("Go to Home");
        homeButton.setBounds(50, 250, 120, 30);
        add(homeButton);
        homeButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b){
            this.setVisible(false);

            new AddHostel().setVisible(true);
            HostelManager h = new HostelManager();
            Hostel hostel = new Hostel(hostelId.getText(), hostelName.getText(), hostelAddress.getText());
            if (!h.addHostel(hostel)){
                JOptionPane.showMessageDialog(null, "Hostel already exists");
            } else {
                JOptionPane.showMessageDialog(null, "Hostel added successfully");
            }

        }
        if (ae.getSource() == homeButton){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }
}
