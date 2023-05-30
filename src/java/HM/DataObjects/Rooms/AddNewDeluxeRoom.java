package HM.DataObjects.Rooms;

import HM.Model.Rooms.DeluxeRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewDeluxeRoom {
    Connection con;

    public AddNewDeluxeRoom(Connection con) {
        this.con = con;
    }
     
   public boolean addDeluxeRoom(DeluxeRoom newroom){
        
        boolean added = false;
        
        try{
            
            String query = "INSERT INTO deluxeroom (type, room_no, ac_status, room_status) VALUES (?,?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, newroom.getType());
            ps.setString(2, newroom.getRoomno());
            ps.setString(3, newroom.getAcstatus());
            ps.setString(4, newroom.getRoomstatus());
           
       
            ps.executeUpdate();
            
    
           
            added = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return added;
        
    }
}
