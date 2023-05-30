package HM.DataObjects.Rooms;

import HM.Model.Rooms.DeluxeRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDeluxeRoom {
    
    Connection con;

    public DeleteDeluxeRoom(Connection con) {
        this.con = con;
    }
     
   public boolean deleteSingleRoom(DeluxeRoom room){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM deluxeroom WHERE RoomID = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, room.getId());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
