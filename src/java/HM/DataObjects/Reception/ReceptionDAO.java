package HM.DataObjects.Reception;

import HM.Model.Users.Reception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReceptionDAO {
    
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ReceptionDAO(Connection con) {
        this.con = con;
    }
    
    public Reception receptionLog(String usermail,String password){
        
        Reception recep = null;
        
        query = "SELECT * FROM reception WHERE r_mail=? AND r_password=?";
        
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,usermail);
            ps.setString(2,password);
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                recep = new Reception();
                
                recep.setUsermail(rs.getString("r_mail"));
                recep.setPassword(rs.getString("r_password"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recep;
        
    }
}
