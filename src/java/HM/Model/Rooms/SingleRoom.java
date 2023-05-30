package HM.Model.Rooms;

public class SingleRoom extends Room{

    public SingleRoom() {
    }

    public SingleRoom(int id) {
        super(id);
    }

    public SingleRoom(String type, String roomno, String acstatus, String roomstatus) {
        super(type, roomno, acstatus, roomstatus);
    }
    
    public SingleRoom(int id, String type, String roomno, String acstatus, String roomstatus) {
        super(id, type, roomno, acstatus, roomstatus);
    }
    
    
    
}
