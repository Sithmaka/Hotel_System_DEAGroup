package HM.DataObjects.Booking;

import HM.Model.Booking.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBooking {
    Connection con;

    public AddBooking(Connection con) {
        this.con = con;
    }
     
   public boolean addBooking(Booking booking){
        
        boolean added = false;
        
        try{
            
            String query = "INSERT INTO booking (room_id, user_mail, nic, room_no, type, ac_status, check_in, check_out) VALUES (?,?,?,?,?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            ps.setInt(1,booking.getRoomid());
            ps.setString(2, booking.getUsermail());
            ps.setString(3, booking.getNic());
            ps.setString(4, booking.getRoomno());
            ps.setString(5, booking.getType());
            ps.setString(6, booking.getAcstatus());
            ps.setString(7, booking.getCheck_in());
            ps.setString(8, booking.getCheck_out());
           
       
            ps.executeUpdate();
            
    
           
            added = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return added;
        
    }
}
