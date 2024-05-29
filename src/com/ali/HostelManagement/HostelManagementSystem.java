package com.ali.HostelManagement;

import java.util.Scanner;

public class HostelManagementSystem {
    public static void main(String[] args) {
        HostelManager manager = new HostelManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a hostel");
            System.out.println("2. Remove a hostel");
            System.out.println("3. Display all hostels");
            System.out.println("4. Display all students");
            System.out.println("5. Add a student");
            System.out.println("6. Remove a student");
            System.out.println("7. Search for a student");
            System.out.println("8. Display all students of a hostel");
            System.out.println("9. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    // Add a hostel
                    System.out.print("Enter hostel ID: ");
                    String hostelId = scanner.nextLine();
                    System.out.print("Enter hostel name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter hostel address: ");
                    String address = scanner.nextLine();
                    manager.addHostel(new Hostel(hostelId, name, address));
                    break;
                case 2:
                    // Remove a hostel
                    // You need to ask for the hostelId here
                    System.out.print("Enter hostel ID: ");
                    String Id = scanner.nextLine();
                    Hostel hostel;
                    hostel = manager.searchHostel(Id);
                    if (hostel == null) {
                        System.out.println("Hostel not found.");
                        break;
                    } else {
                        manager.removeHostel(hostel);
                        System.out.println("Hostel removed.");
                    }

                    break;
                case 3:
                    // Display all hostels
                    manager.displayHostels();
                    break;
                case 4:
                    // Edit hostel details
                    // You need to ask for the hostelId and new details here
                    manager.displayAllStudents();
                    break;
                case 5:
                    // Add a student
                    // You need to ask for the student details here
                    String studentID;
                    do {
                        System.out.print("Enter student ID: ");
                        studentID = scanner.nextLine();
                    } while (manager.checkDuplicateStudentID(studentID));
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    System.out.print("Enter Gender: ");
                    String studentGender = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String studentContactNumber = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int studentRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    Hostel hostel1;
                    do {
                        System.out.println("Enter hostel ID: ");
                        String id = scanner.nextLine();
                        hostel1 = manager.searchHostel(id);
                    } while (hostel1 == null);
                    manager.addStudent(new Student(studentID, studentName, studentAge, studentGender, studentContactNumber, studentRoomNumber), hostel1);
                    break;
                case 6:
                    // Remove a student
                    // You need to ask for the studentId here
                    System.out.print("Enter student ID: ");
                    String studentID1 = scanner.nextLine();
                    Student student;
                    student = manager.searchStudent(studentID1);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    } else {
                        Hostel hostel2 = manager.searchHostelByStudentID(studentID1);
                        manager.removeStudent(student, hostel2);
                        System.out.println("Student removed.");
                    }
                    break;
                case 7:
                    Student student1;
                    // Search for a student
                    // You need to ask for the studentId here
                    System.out.print("Enter student ID: ");
                    String studentID2 = scanner.nextLine();
                    student1 = manager.searchStudent(studentID2);
                    if (student1 == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println("Student found.");
                        System.out.println("Student ID: " + student1.getStudentID());
                        System.out.println("Student Name: " + student1.getName());
                        System.out.println("Student Age: " + student1.getAge());
                        System.out.println("Stugent Gender: " + student1.getGender());
                        System.out.println("Student Contact Number: " + student1.getContactNumber());
                        System.out.println("Student Room Number: " + student1.getRoomNumber());
                    }
                    break;
                case 8:
                    // Display all students of a hostel
                    // You need to ask for the hostelId here
                    System.out.println("Enter hostel ID: ");
                    String hostelID1 = scanner.nextLine();
                    Hostel hostel2 = manager.searchHostel(hostelID1);
                    if (hostel2 == null) {
                        System.out.println("Hostel not found.");
                        break;
                    }
                    manager.displayStudents(manager.searchHostel(hostelID1));
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 9.");
            }
        }
    }
}