/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HM.DataObjects.Rooms;

import HM.Model.Rooms.SingleRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
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
