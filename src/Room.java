import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean available;
    private ArrayList<Student> occupants;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<Student> getOccupants() {
        return occupants;
    }

    public void setOccupants(ArrayList<Student> occupants) {
        this.occupants = occupants;
    }

    public Room(int roomNumber, int capacity, boolean available) {
        setRoomNumber(roomNumber);
        setCapacity(capacity);
        setAvailable(available);
        this.occupants = new ArrayList<Student>();
    }

    public Room(int roomNumber, int capacity) {
        this(roomNumber, capacity, true);
    }

    public String toString() {
        return "Room number: " + getRoomNumber() + "\nCapacity: " + getCapacity() + "\nAvailable: " + isAvailable() + "\nOccupants: " + getOccupants();
    }
}
