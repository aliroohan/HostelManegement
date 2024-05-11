import java.io.*;
import java.util.Scanner;

public class HostelManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("S001", "John", 19, "Male", "0123456789", 101);
        Student student2 = new Student("S002", "Jane", 20, "Female", "9876543210", 102);
        Student student3 = new Student("S003", "Doe", 19, "Male", "0123456789", 103);
        HostelManager hostelManager = new HostelManager();
        Hostel hostel1 = new Hostel("H001", "Hostel A", "123 Main Street");
        Hostel hostel2 = new Hostel("H002", "Hostel B", "321 Main Street");
        Room room1 = new Room(101, 4);
        Room room2 = new Room(102, 4);
        hostel1.getRooms().add(room1);
        hostel2.getRooms().add(room2);
        hostelManager.getHostels().add(hostel1);
        hostelManager.getHostels().add(hostel2);


//        hostelManager.addStudent(student3, hostel2);
//        hostelManager.editDetails(student1, hostel1);
        hostelManager.editDetails(student3, hostel1);
//        hostelManager.displayAllStudents();
//        hostelManager.displayStudents(hostel1);
        hostelManager.displayStudents(hostel2);
//        hostelManager.searchStudent("S001", hostel1);
//        hostelManager.searchStudent("S002", hostel1);
//        hostelManager.removeStudent(student3, hostel2);
//        hostelManager.searchStudent("S003", hostel1);
    }
}
