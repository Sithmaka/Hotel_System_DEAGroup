package HM.DataObjects.Booking;

import HM.Model.Rooms.DeluxeRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDeluxeRoomStatus {
    Connection con;

    public UpdateDeluxeRoomStatus(Connection con) {
        this.con = con;
    }
     
   public boolean updateRoomStatusDeluxe(DeluxeRoom room){
        
       boolean updated = false;
        
        try{
            
            String query = "UPDATE deluxeroom SET  room_status='Booked' WHERE RoomId= ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            
            ps.setInt(1, room.getId());
           
           ps.executeUpdate();
           
           updated = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return updated;
   }
   
    public boolean updateRoomStatusAvailable(DeluxeRoom room){
        
       boolean updated = false;
        
        try{
            
            String query = "UPDATE deluxeroom SET  room_status='Available' WHERE RoomId= ?";
           
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
