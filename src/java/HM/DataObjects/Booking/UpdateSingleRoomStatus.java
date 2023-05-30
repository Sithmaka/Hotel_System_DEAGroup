package HM.DataObjects.Booking;

import HM.Model.Rooms.SingleRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSingleRoomStatus {
    
    Connection con;

    public UpdateSingleRoomStatus(Connection con) {
        this.con = con;
    }
     
   public boolean updateRoomStatusSingle(SingleRoom room){
        
       boolean updated = false;
        
        try{
            
            String query = "UPDATE singleroom SET  room_status='Booked' WHERE RoomId= ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setInt(1, room.getId());
           
           ps.executeUpdate();
           
           updated = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return updated;
   }
   
   public boolean updateRoomStatusAvailable(SingleRoom room){
        
       boolean updated = false;
        
        try{
            
            String query = "UPDATE singleroom SET  room_status='Available' WHERE RoomId= ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setInt(1, room.getId());
           
           ps.executeUpdate();
           
           updated = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return updated;
   }
}
