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
            System.out.println("4. Add a room to a hostel");
            System.out.println("5. Remove a room from a hostel");
            System.out.println("6. Search for a hostel");
            System.out.println("7. Edit hostel details");
            System.out.println("8. Add a student");
            System.out.println("9. Remove a student");
            System.out.println("10. Edit student details");
            System.out.println("11. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    // Add a hostel
                    // You need to ask for the details of the hostel here
                    break;
                case 2:
                    // Remove a hostel
                    // You need to ask for the hostelId here
                    break;
                case 3:
                    // Add a room to a hostel
                    // You need to ask for the room details and hostelId here
                    break;
                case 4:
                    // Remove a room from a hostel
                    // You need to ask for the room details and hostelId here
                    break;
                case 5:
                    // Search for a hostel
                    // You need to ask for the hostelId here
                    break;
                case 6:
                    // Edit hostel details
                    // You need to ask for the hostelId and new details here
                    break;
                case 7:
                    // Add a student
                    // You need to ask for the student details here
                    break;
                case 8:
                    // Remove a student
                    // You need to ask for the studentId here
                    break;
                case 9:
                    // Edit student details
                    // You need to ask for the studentId and new details here
                    break;
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 10.");
            }
        }
    }
}