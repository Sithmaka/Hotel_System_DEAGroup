package HM.DataObjects.Customer;

import HM.Model.Users.RegisteredCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToLogin {
    
    Connection con;

    public AddToLogin(Connection con) {
        this.con = con;
    }
     
    public boolean addLoginCustomer(RegisteredCustomer customer){
        
        boolean added = false;
        
        try{
            
            String query = "INSERT INTO login (usermail, role, password) VALUES (?,?,?)";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, customer.getUsermail());
            ps.setString(2, customer.getRole());
            ps.setString(3, customer.getPassword());
          
           ps.executeUpdate();
           
           added = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return added;
    }
}
