package com.ali.HostelManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveHostel extends JFrame implements ActionListener {
    JTextField hostelId;
    JButton b;
    public static void main(String[] args) {
        new RemoveHostel().setVisible(true);
    }

    public RemoveHostel() {
        setBounds(600, 200, 850, 570);
        setLayout(null);

        JLabel l1 = new JLabel("Hostel Id");
        l1.setBounds(30, 50, 100, 30);
        add(l1);

        hostelId = new JTextField();
        hostelId.setBounds(150, 50, 150, 30);
        add(hostelId);

        b = new JButton("Remove Hostel");
        b.setBackground(UIManager.getColor("Button.disabledShadow"));
        b.setForeground(UIManager.getColor("Button.disabledForeground"));

        b.setBounds(50, 210, 100, 30);
        add(b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b){
            this.setVisible(false);
            new RemoveHostel().setVisible(true);
            HostelManager hostelManager = new HostelManager();
            Hostel hostel = hostelManager.searchHostel(hostelId.getText());
            if (hostel != null) {
                JOptionPane.showMessageDialog(null, hostel.getHostelId() + "," + hostel.getName() + "," + hostel.getAddress() + " removed successfully");
                hostelManager.removeHostel(hostel);
            } else {
                JOptionPane.showMessageDialog(null, "Hostel not found");
            }
        }
    }
}
