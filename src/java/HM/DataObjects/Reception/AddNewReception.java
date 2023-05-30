package HM.DataObjects.Reception;

import HM.Model.Users.Reception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewReception {
    Connection con;

    public AddNewReception(Connection con) {
        this.con = con;
    }
     
   public boolean addReception(Reception newreception){
        
        boolean added = false;
        
        try{
            
            String query = "INSERT INTO reception (r_mail, r_password) VALUES (?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, newreception.getUsermail());
            ps.setString(2, newreception.getPassword());
           
       
            ps.executeUpdate();
            
    
           
            added = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return added;
        
    }
}
