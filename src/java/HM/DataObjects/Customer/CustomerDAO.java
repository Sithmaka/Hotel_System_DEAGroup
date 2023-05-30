package HM.DataObjects.Customer;

import HM.Model.Users.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    
    private Connection con;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public CustomerDAO(Connection con) {
        this.con = con;
    }
    
    public Customer customerLog(String usermail,String password){
        
        Customer customer = null;
        
        query = "SELECT * FROM customer WHERE user_mail=? AND user_password=?";
        
        try {
            ps = this.con.prepareStatement(query);
            ps.setString(1,usermail);
            ps.setString(2,password);
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                customer = new Customer();
                
                customer.setUsername(rs.getString("username"));
                customer.setUsermail(rs.getString("user_mail"));
                customer.setPassword(rs.getString("user_password"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
        
    }
}
