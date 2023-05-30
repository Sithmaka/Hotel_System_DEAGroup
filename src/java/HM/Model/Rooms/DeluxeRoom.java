package HM.Model.Rooms;

public class DeluxeRoom extends Room{

    public DeluxeRoom() {
    }

    public DeluxeRoom(int id) {
        super(id);
    }

    public DeluxeRoom(String type, String roomno, String acstatus, String roomstatus) {
        super(type, roomno, acstatus, roomstatus);
    }
    
    public DeluxeRoom(int id, String type, String roomno, String acstatus, String roomstatus) {
        super(id, type, roomno, acstatus, roomstatus);
    }
    
}
