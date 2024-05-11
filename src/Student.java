public class Student {
    private String studentID;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private int roomNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Student(String studentID, String name, int age, String gender, String contactNumber, int roomNumber) {
        setStudentID(studentID);
        setName(name);
        setAge(age);
        setGender(gender);
        setContactNumber(contactNumber);
        setRoomNumber(roomNumber);
    }

    @Override
    public String toString() {
        return "Student ID: " + getStudentID() + "\nName: " + getName() + "\nAge: " + getAge() + "\nGender: " + getGender() + "\nContact Number: " + getContactNumber() + "\nRoom Number: " + getRoomNumber();
    }
}