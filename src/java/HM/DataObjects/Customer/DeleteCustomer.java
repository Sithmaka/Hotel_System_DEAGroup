package HM.DataObjects.Customer;


import HM.Model.Users.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCustomer {
    Connection con;

    public DeleteCustomer(Connection con) {
        this.con = con;
    }
     
   public boolean deleteCustomer(Customer customer){
        boolean deleted = false;
        
        try{
            
            String query = "DELETE FROM customer WHERE UID = ?";
           
            
            PreparedStatement ps = this.con.prepareStatement(query);
      
            
            ps.setInt(1, customer.getId());
            
           
       
            ps.executeUpdate();
            
    
           
            deleted = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
