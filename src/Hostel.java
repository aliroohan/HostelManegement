import java.util.List;

public class Hostel {
    private String hostelId;
    private String name;
    private String address;
    private List<Room> rooms;

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Hostel(String hostelId, String name, String address, List<Room> rooms) {
        setHostelId(hostelId);
        setName(name);
        setAddress(address);
        setRooms(rooms);
    }
}
