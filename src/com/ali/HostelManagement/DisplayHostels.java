package com.ali.HostelManagement;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayHostels extends JFrame{
    JTable table;
    JLabel title;
    JButton home;

    public static void main(String[] args) {
        new DisplayHostels().setVisible(true);
    }

    public DisplayHostels(){
        setBounds(600, 200, 850, 570);
        setTitle("Hostels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        title = new JLabel("Hostels");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        title.setBounds(375, 10, 100, 30);
        add(title);

        String [] columnsNames = {"Hostel Id", "Name", "Address"};
        HostelManager hostelManager = new HostelManager();
        ArrayList<Hostel> hostels= hostelManager.getHostels();
        Hostel [] h = new Hostel[hostels.size()];
        String [][] data = new String[h.length][3];
        for (int i = 0; i < h.length; i++) {
            data[i][0] = hostels.get(i).getHostelId();
            data[i][1] = hostels.get(i).getName();
            data[i][2] = hostels.get(i).getAddress();
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
