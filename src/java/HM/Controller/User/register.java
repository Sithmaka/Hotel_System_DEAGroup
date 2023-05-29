package HM.Controller.User;

import HM.DataObjects.Customer.AddToLogin;
import HM.DataObjects.Customer.RegisterDAO;
import HM.Database.DatabaseConnection;
import HM.Model.Users.RegisteredCustomer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class register extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        try {
            
            String username = request.getParameter("username");
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            
            RegisteredCustomer rc = new RegisteredCustomer(username, usermail,password, role);
            
            
            RegisterDAO regCustomer = new RegisterDAO(DatabaseConnection.getCon());
            
            AddToLogin atl = new AddToLogin(DatabaseConnection.getCon());
            
            if (regCustomer.registerCustomer(rc) && atl.addLoginCustomer(rc)) {
                
                response.sendRedirect("login.html");
                
            } else {
               
                response.sendRedirect("login.html");
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
