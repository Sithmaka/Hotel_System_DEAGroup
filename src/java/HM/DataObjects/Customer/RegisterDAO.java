package HM.DataObjects.Customer;

import HM.Model.Users.RegisteredCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDAO {
    
    Connection con;

    public RegisterDAO(Connection con) {
        this.con = con;
    }
     
    public boolean registerCustomer(RegisteredCustomer customer){
        
        boolean registered = false;
        
        try{
            
            String query = "INSERT INTO customer (username, user_mail, user_password) VALUES (?,?,?)";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getUsermail());
            ps.setString(3, customer.getPassword());
          
           ps.executeUpdate();
           
           registered = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registered;
    }
}
