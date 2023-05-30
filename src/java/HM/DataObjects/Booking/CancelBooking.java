package HM.DataObjects.Booking;

import HM.Model.Booking.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelBooking {
    Connection con;

    public CancelBooking(Connection con) {
        this.con = con;
    }
     
   public boolean cancelBooking(Booking booking){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM booking WHERE BID = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, booking.getBid());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
