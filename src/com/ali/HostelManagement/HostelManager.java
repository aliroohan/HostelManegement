package com.ali.HostelManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class HostelManager {
    private ArrayList<Hostel> hostels = new ArrayList<>();

    public ArrayList<Hostel> getHostels() {
        return hostels;
    }

    public HostelManager() {
        // Constructor
        File hostelDirectory = new File("Hostel.txt");
        if (hostelDirectory.exists()) {
            try {
                Scanner scanner = new Scanner(hostelDirectory);
                while (scanner.hasNextLine()) {
                    String[] hostelInfo = scanner.nextLine().split(",");
                    Hostel hostel = new Hostel(hostelInfo[0], hostelInfo[1], hostelInfo[2]);
                    hostels.add(hostel);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        for (Hostel hostel : hostels) {
            File file = new File(hostel.getName() + ".txt");
            if (file.exists()) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String[] studentInfo = scanner.nextLine().split(",");
                        Student student = new Student(studentInfo[0], studentInfo[1], Integer.parseInt(studentInfo[2]), studentInfo[3], studentInfo[4], Integer.parseInt(studentInfo[5]));
                        hostel.getStudents().add(student);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void addHostel(Hostel hostel) {
        // Add hostel
        for (Hostel h : hostels) {
            if (h.getHostelId().equals(hostel.getHostelId())) {
                System.out.println("Hostel with similar ID already exists.\nTry Different ID");
                return;
            }
        }
        hostels.add(hostel);
        try {
            FileWriter writer = new FileWriter("Hostel.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(hostel.getHostelId() + "," + hostel.getName() + "," + hostel.getAddress());
            bufferedWriter.newLine();
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            File file = new File(hostel.getName() + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeHostel(Hostel hostel) {
        // Remove hostel
        hostels.remove(hostel);
        File file = new File(hostel.getName() + ".txt");
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
        FileReader fileReader = null;
        ArrayList<Hostel> tempHostels = new ArrayList<>();
        try {
            fileReader = new FileReader("Hostel.txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] hostelInfo = scanner.nextLine().split(",");
                if (!hostelInfo[0].equals(hostel.getHostelId())) {
                    tempHostels.add(new Hostel(hostelInfo[0], hostelInfo[1], hostelInfo[2]));
                }
            }
            fileReader.close();
            FileWriter writer = new FileWriter("Hostel.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(tempHostels.getFirst().getHostelId() + "," + tempHostels.getFirst().getName() + "," + tempHostels.getFirst().getAddress());
            bufferedWriter.newLine();
            tempHostels.remove(0);
            bufferedWriter.close();
            writer.close();
            writer = new FileWriter("Hostel.txt", true);
            bufferedWriter = new BufferedWriter(writer);
            for (Hostel tempHostel : tempHostels) {
                bufferedWriter.write(tempHostel.getHostelId() + "," + tempHostel.getName() + "," + tempHostel.getAddress());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Hostel searchHostel(String hostelId) {
        // Search for hostel
        for (Hostel hostel : hostels) {
            if (hostel.getHostelId().equals(hostelId)) {
                return hostel;
            }
        }
        return null;
    }
    public void displayHostels() {
        // Display all hostels
        for (Hostel hostel : hostels) {
            System.out.println("Hostel ID: " + hostel.getHostelId());
            System.out.println("Name: " + hostel.getName());
            System.out.println("Address: " + hostel.getAddress());
            System.out.println();
        }
    }

    public boolean checkDuplicateStudentID(String studentID) {
        for (Hostel hostel : hostels) {
            if (!hostel.getStudents().isEmpty()) {
                for (Student student : hostel.getStudents()) {
                    if (student.getStudentID().equals(studentID)) {
                        System.out.println("Student with similar ID already exists.\nTry Different ID");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addStudentToHostelFile(Student student, Hostel hostel) {
        try {
            FileWriter writer = new FileWriter(hostel.getName() + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Methods to manage hostels, rooms, and students
    public void addStudent(Student student, Hostel hostel) {
        // Add student to hostel
        addStudentToHostelFile(student, hostel);
        hostels.get(hostels.indexOf(hostel)).getStudents().add(student);
    }

    public void removeStudent(Student student, Hostel hostel) {
        // Remove student from hostel
        this.removeStudentFromHostelFile(student, hostel);
        hostels.get(hostels.indexOf(hostel)).getStudents().remove(student);
    }

    public void removeStudentFromHostelFile(Student student, Hostel hostel) {
        ArrayList<Student> tempStudents = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(hostel.getName() + ".txt");
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] studentInfo = scanner.nextLine().split(",");
                if (!studentInfo[0].equals(student.getStudentID())) {
                    tempStudents.add(new Student(studentInfo[0], studentInfo[1], Integer.parseInt(studentInfo[2]), studentInfo[3], studentInfo[4], Integer.parseInt(studentInfo[5])));
                }
            }
            fileReader.close();
            FileWriter writer = new FileWriter(hostel.getName() + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(tempStudents.getFirst().toString());
            bufferedWriter.newLine();
            tempStudents.removeFirst();
            for (Student tempStudent : tempStudents) {
                bufferedWriter.write(tempStudent.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Hostel searchHostelByStudentID(String studentID) {
        // Search for hostel by student ID
        for (Hostel hostel : hostels) {
            for (Student student : hostel.getStudents()) {
                if (student.getStudentID().equals(studentID)) {
                    return hostel;
                }
            }
        }
        return null;
    }

    public Student searchStudent(String studentID) {
        // Search for student in hostel
        for (Hostel hostel : hostels) {
            for (Student student : hostel.getStudents()) {
                if (student.getStudentID().equals(studentID)) {
                    return student;
                }
            }
        }
        return null;
    }

    public void displayStudents(Hostel hostel) {
        // Display all students in hostel
        for (Hostel h : hostels) {
            if (h.getHostelId().equals(hostel.getHostelId())) {
                for (Student student : h.getStudents()) {
                    System.out.println("Student ID: " + student.getStudentID());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Age: " + student.getAge());
                    System.out.println("Gender: " + student.getGender());
                    System.out.println("Phone number: " + student.getContactNumber());
                    System.out.println("Room number: " + student.getRoomNumber());
                    System.out.println();
                }
            }
        }
    }

    public void displayAllStudents() {
        // Display all students in all hostels
        for (Hostel hostel : hostels) {
            FileReader fileReader = null;
            try {
                System.out.println("Hostel: " + hostel.getName());
                System.out.println();
                fileReader = new FileReader(hostel.getName() + ".txt");
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    String[] student = scanner.nextLine().split(",");
                    System.out.println("Student ID: " + student[0]);
                    System.out.println("Name: " + student[1]);
                    System.out.println("Age: " + student[2]);
                    System.out.println("Gender: " + student[3]);
                    System.out.println("Phone number: " + student[4]);
                    System.out.println("Room number: " + student[5]);
                    System.out.println();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fileReader != null) {
                        fileReader.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void editDetails(Student student, Hostel hostel) {
        // Edit student details
        FileReader fileReader = null;
        File tempFile = new File("temp.txt");
        File hostelFile = new File(hostel.getName() + ".txt");
        try {
            tempFile.createNewFile();
            fileReader = new FileReader(hostel.getName() + ".txt");
            Scanner scanner = new Scanner(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            boolean studentFound = false;
            while (scanner.hasNextLine()) {
                String[] studentInfo = scanner.nextLine().split(",");
                if (studentInfo[0].equals(student.getStudentID())) {
                    Student updatedStudent = new Student(student.getStudentID(), student.getName(), student.getAge(), student.getGender(), student.getContactNumber(), student.getRoomNumber());
                    System.out.println("What do you want to update?");
                    System.out.println("1. Age");
                    System.out.println("2. Phone number");
                    System.out.println("3. Room number");
                    Scanner input = new Scanner(System.in);
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new age: ");
                            updatedStudent.setAge(input.nextInt());
                            break;
                        case 2:
                            System.out.println("Enter new phone number: ");
                            updatedStudent.setContactNumber(input.nextLine());
                            break;
                        case 3:
                            System.out.println("Enter new room number: ");
                            updatedStudent.setRoomNumber(input.nextInt());
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }

                    bufferedWriter.write(updatedStudent.toString());
                    bufferedWriter.newLine();
                    studentFound = true;
                } else {
                    bufferedWriter.write(studentInfo[0] + "," + studentInfo[1] + "," + studentInfo[2] + "," + studentInfo[3] + "," + studentInfo[4] + "," + studentInfo[5]);
                    bufferedWriter.newLine();
                }
            }
            if (!studentFound) {
                System.out.println("Student not found.");
            }
            bufferedWriter.close();
            fileReader.close();
            hostelFile.delete();
            if (!tempFile.renameTo(new File(hostel.getName() + ".txt"))) {
                throw new RuntimeException("Could not rename file");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
