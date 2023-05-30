package HM.DataObjects.Customer;

import HM.Model.Users.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewCustomer {
    Connection con;

    public AddNewCustomer(Connection con) {
        this.con = con;
    }
     
   public boolean addCustomer(Customer newcustomer){
        
        boolean added = false;
        
        try{
            
            String query = "INSERT INTO customer (username, user_mail, user_password) VALUES (?,?,?)";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setString(1, newcustomer.getUsername());
            ps.setString(2, newcustomer.getUsermail());
            ps.setString(3, newcustomer.getPassword());
           
       
            ps.executeUpdate();
            
    
           
            added = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return added;
        
    }
}
