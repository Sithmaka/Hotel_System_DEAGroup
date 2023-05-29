/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HM.DataObjects.Reception;

import HM.Model.Users.Reception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raffael
 */
public class UpdateReception {
    Connection con;

    public UpdateReception(Connection con) {
        this.con = con;
    }
     
   public boolean updateReception(Reception uprecep){
        boolean updated = false;
        
        try{
            
            String query = "UPDATE reception SET  r_mail = ? WHERE RID = ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, uprecep.getUsermail());
            ps.setInt(2, uprecep.getId());
           
           ps.executeUpdate();
           
           updated = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return updated;
    }
}
