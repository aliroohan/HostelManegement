import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HostelManager {
    private ArrayList<Hostel> hostels;

    // Methods to manage hostels, rooms, and students
    public void addStudent(Student student, Hostel hostel) {
        // Add student to hostel
        File file = new File(hostel.getName() + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(hostel.getName() + ".txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
                bufferedWriter.close();
                System.out.println("Successfully wrote to the file.");
                writer.close();
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter writer = new FileWriter(hostel.getName() + ".txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
                bufferedWriter.close();
                System.out.println("Successfully wrote to the file.");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeStudent(Student student, Hostel hostel) {
        // Remove student from hostel
        FileReader fileReader = null;
        File tempFile = new File("temp.txt");
        File hostelFile = new File(hostel.getName() + ".txt");
        try {
            tempFile.createNewFile();
            fileReader = new FileReader(hostel.getName() + ".txt");
            Scanner scanner = new Scanner(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
            while (scanner.hasNextLine()) {
                String[] studentInfo = scanner.nextLine().split(",");
                if (!studentInfo[0].equals(student.getStudentID())) {
                    bufferedWriter.write(studentInfo[0] + "," + studentInfo[1] + "," + studentInfo[2] + "," + studentInfo[3] + "," + studentInfo[4] + "," + studentInfo[5]);
                    bufferedWriter.newLine();
                }
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

    public void assignRoom(Student student, Room room) {
        // Assign room to student
    }

    public void searchStudent(String studentID, Hostel hostel) {
        // Search for student in hostel
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(hostel.getName() + ".txt");
            Scanner scanner = new Scanner(fileReader);
            boolean studentFound = false;
            while (scanner.hasNextLine()) {
                String[] student = scanner.nextLine().split(",");
                if (student[0].equals(studentID)) {
                    System.out.println("Student ID: " + student[0]);
                    System.out.println("Name: " + student[1]);
                    System.out.println("Age: " + student[2]);
                    System.out.println("Gender: " + student[3]);
                    System.out.println("Phone number: " + student[4]);
                    System.out.println("Room number: " + student[5]);
                    System.out.println();
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound) {
                System.out.println("Student not found.");
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

    // Other methods for hostel management
}
