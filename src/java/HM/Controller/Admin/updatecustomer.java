package HM.Controller.Admin;

import HM.DataObjects.Customer.UpdateCustomer;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class updatecustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            String username = request.getParameter("username");
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("uid"));
            
            Customer customer = new Customer(id, username, usermail, password);
            
            UpdateCustomer updatedcustomer = new UpdateCustomer(DatabaseConnection.getCon());
            
            if(updatedcustomer.updateCustomer(customer)){
                
                response.sendRedirect("customers.jsp");
            }else{
                response.sendRedirect("updatecustomer.jsp");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(updatereception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
