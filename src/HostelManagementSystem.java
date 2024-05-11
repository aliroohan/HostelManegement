import java.io.*;
import java.util.Scanner;

public class HostelManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("S001", "John", 19, "Male", "0123456789", 101);
        Student student2 = new Student("S002", "Jane", 20, "Female", "9876543210", 102);
        Student student3 = new Student("S003", "Doe", 19, "Male", "0123456789", 103);
        HostelManager hostelManager = new HostelManager();
        Hostel hostel1 = new Hostel("H001", "Hostel A", "123 Main Street");
        Room room1 = new Room(101, 4);
        hostel1.getRooms().add(room1);
//        hostelManager.addStudent(student1, hostel1);
//        hostelManager.addStudent(student2, hostel1);
//        hostelManager.addStudent(student3, hostel1);
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader("Hostel A.txt");
//            Scanner scanner = new Scanner(fileReader);
//            while (scanner.hasNextLine()) {
//                String [] student = scanner.nextLine().split(",");
//                System.out.println("Student ID: " + student[0]);
//                System.out.println("Name: " + student[1]);
//                System.out.println("Age: " + student[2]);
//                System.out.println("Gender: " + student[3]);
//                System.out.println("Phone number: " + student[4]);
//                System.out.println("Room number: " + student[5]);
//                System.out.println();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        hostelManager.searchStudent("S001", hostel1);
        hostelManager.searchStudent("S002", hostel1);
        hostelManager.removeStudent(student3, hostel1);
        hostelManager.searchStudent("S003", hostel1);
    }
}
