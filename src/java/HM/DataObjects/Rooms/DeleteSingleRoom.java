package HM.DataObjects.Rooms;

import HM.Model.Rooms.SingleRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteSingleRoom {
    Connection con;

    public DeleteSingleRoom(Connection con) {
        this.con = con;
    }
     
   public boolean deleteSingleRoom(SingleRoom room){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM singleroom WHERE RoomID = ?";
           
            
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
