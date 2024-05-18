package com.ali.HostelManagement;

import java.util.ArrayList;
import java.util.List;

public class Hostel {
    private String hostelId;
    private String name;
    private String address;
    private ArrayList<Student> students;

    public String getHostelId() {
        return hostelId;
    }

    public void setHostelId(String hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Hostel(String hostelId, String name, String address) {
        setHostelId(hostelId);
        setName(name);
        setAddress(address);
        this.students = new ArrayList<Student>();
    }
}
