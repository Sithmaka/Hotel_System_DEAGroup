package HM.DataObjects.Customer;


import HM.Model.Users.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomer {
    Connection con;

    public UpdateCustomer(Connection con) {
        this.con = con;
    }
     
   public boolean updateCustomer(Customer customer){
        
       boolean updated = false;
        
        try{
            
            String query = "UPDATE customer SET  username = ?, user_mail = ?, user_password = ? WHERE UID = ?";
           
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getUsermail());
            ps.setString(3, customer.getPassword());
            ps.setInt(4, customer.getId());
           
           ps.executeUpdate();
           
           updated = true;
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return updated;
   }
}
