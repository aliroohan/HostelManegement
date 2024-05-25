package com.ali.HostelManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveStudent extends JFrame implements ActionListener {
    JTextField studentId;
    JButton removeStudent;

    public static void main(String[] args) {
        new RemoveStudent().setVisible(true);
    }

    public RemoveStudent() {
        setBounds(600, 200, 850, 570);
        setLayout(null);

        JLabel l1 = new JLabel("Student ID");
        l1.setBounds(30, 50, 100, 30);
        add(l1);

        studentId = new JTextField();
        studentId.setBounds(150, 50, 150, 30);
        add(studentId);

        removeStudent = new JButton("Remove Student");
        removeStudent.setBackground(UIManager.getColor("Button.disabledShadow"));
        removeStudent.setForeground(UIManager.getColor("Button.disabledForeground"));

        removeStudent.setBounds(50, 210, 150, 30);
        add(removeStudent);
        removeStudent.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == removeStudent){
            this.setVisible(false);
            new RemoveStudent().setVisible(true);
            HostelManager hostelManager = new HostelManager();
            Student student = hostelManager.searchStudent(studentId.getText());
            Hostel hostel = hostelManager.searchHostelByStudentID(studentId.getText());
            if (student != null) {
                JOptionPane.showMessageDialog(null, student.getStudentID() + "," + student.getName() +  " removed successfully");
                hostelManager.removeStudent(student, hostel);
            } else {
                JOptionPane.showMessageDialog(null, "Student not found");
            }
        }
    }
}
