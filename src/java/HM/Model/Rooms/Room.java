package HM.Model.Rooms;

public class Room {
   
    public int id;
    public String type;
    public String roomno;
    public String acstatus;
    public String roomstatus;

    public Room() {
    }

    public Room(int id) {
        this.id = id;
    }

    public Room(String type, String roomno, String acstatus, String roomstatus) {
        this.type = type;
        this.roomno = roomno;
        this.acstatus = acstatus;
        this.roomstatus = roomstatus;
    }
    
    
    
    public Room(int id, String type, String roomno, String acstatus, String roomstatus) {
        this.id = id;
        this.type = type;
        this.roomno = roomno;
        this.acstatus = acstatus;
        this.roomstatus = roomstatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getAcstatus() {
        return acstatus;
    }

    public void setAcstatus(String acstatus) {
        this.acstatus = acstatus;
    }

    public String getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(String roomstatus) {
        this.roomstatus = roomstatus;
    }
    
    
    
    
    
}
