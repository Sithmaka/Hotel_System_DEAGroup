package HM.DataObjects.Reception;

import HM.Model.Users.Reception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteReception {
    
    Connection con;

    public DeleteReception(Connection con) {
        this.con = con;
    }
     
   public boolean deleteReception(Reception recep){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM reception WHERE RID = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, recep.getId());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
