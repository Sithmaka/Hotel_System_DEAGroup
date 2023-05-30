package HM.Model.Booking;

public class Booking {
    
    public int bid;
    public int roomid;
    public String type;
    public String roomno;
    public String acstatus;
    public String roomstatus;
    public String usermail;
    public String nic;
    public String check_in;
    public String check_out;

    public Booking(int bid, int roomid) {
        this.bid = bid;
        this.roomid = roomid;
    }

    
    public Booking(String type, String roomno, String acstatus, String usermail, String nic, String check_in, String check_out) {
        this.type = type;
        this.roomno = roomno;
        this.acstatus = acstatus;
        this.usermail = usermail;
        this.nic = nic;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public Booking(int roomid, String type, String roomno, String acstatus, String usermail, String nic, String check_in, String check_out) {
        this.roomid = roomid;
        this.type = type;
        this.roomno = roomno;
        this.acstatus = acstatus;
        this.usermail = usermail;
        this.nic = nic;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
    
    

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }
    
    
}
