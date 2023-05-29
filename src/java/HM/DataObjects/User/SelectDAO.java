package HM.DataObjects.User;


import HM.DataObjects.Admin.AdminDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SelectDAO {
    
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public SelectDAO(Connection con) {
        this.con = con;
    }
    
    public String selectUser(String usermail, String password){
        
        String role = null;
        
        query = "SELECT role FROM login WHERE usermail=? AND password=?";
        
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1, usermail);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return role;

    }

}
