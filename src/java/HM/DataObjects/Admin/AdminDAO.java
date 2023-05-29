package HM.DataObjects.Admin;

import HM.Model.Users.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDAO {
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public AdminDAO(Connection con) {
        this.con = con;
    }
    
    public Admin adminLog(String usermail,String password){
        Admin admin = null;
        
        query = "SELECT * FROM admin WHERE admin_mail=? AND admin_password=?";
        
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,usermail);
            ps.setString(2,password);
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                admin = new Admin();
                
                admin.setUsermail(rs.getString("admin_mail"));
                admin.setPassword(rs.getString("admin_password"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
}
