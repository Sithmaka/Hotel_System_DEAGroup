package HM.Controller.Admin;

import HM.DataObjects.Customer.DeleteCustomer;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class customerupdate extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int uid = Integer.parseInt(request.getParameter("uid"));
        String button = request.getParameter("button");
        
        Customer customer;
        DeleteCustomer dc;
        
        if(button.equals("Delete")){
            
            try {
                customer = new Customer(uid);
                dc = new DeleteCustomer(DatabaseConnection.getCon());
                
                if(dc.deleteCustomer(customer)){
                
                    response.sendRedirect("customers.jsp");
                    
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(customerupdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else {
                
                String username = request.getParameter("username");
                String usermail = request.getParameter("usermail");
                String password = request.getParameter("password");
                
                String url = "updatecustomer.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                
                request.setAttribute("uid", uid);
                request.setAttribute("username", username);
                request.setAttribute("usermail", usermail);
                request.setAttribute("password", password);
                
                	
                rd.forward(request, response);
                
            }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
