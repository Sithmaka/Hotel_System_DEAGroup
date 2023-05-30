package HM.Controller.Admin;

import HM.DataObjects.Customer.AddNewCustomer;
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

public class addcustomer extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String username = request.getParameter("username");
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            
            Customer newcustomer = new Customer(username, usermail, password);
            
            AddNewCustomer addnewcustomer = new AddNewCustomer(DatabaseConnection.getCon());
            
            if(addnewcustomer.addCustomer(newcustomer)){
                response.sendRedirect("customers.jsp");
            }else{
                response.sendRedirect("addcustomer.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(addcustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
