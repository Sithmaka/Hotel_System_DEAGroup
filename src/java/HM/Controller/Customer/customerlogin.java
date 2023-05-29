package HM.Controller.Customer;


import HM.DataObjects.Customer.CustomerDAO;
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
import javax.servlet.http.HttpSession;


public class customerlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usermail = request.getParameter("usermail");
        String password = request.getParameter("password");
        
        try {
            
            CustomerDAO customerdao = new CustomerDAO(DatabaseConnection.getCon());
            
            Customer customer = customerdao.customerLog(usermail,password);
            
            if(customer!=null){
                
                HttpSession session = request.getSession();
                
                session.setAttribute("loggedUser", customer);
                session.setAttribute("role","customer");
                
                String url = "/HotelManagement/View/JSP/customer/";
                response.sendRedirect(url + "customerdashboard.jsp");
                
            }else{
                
                response.sendRedirect("login.html");
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(customerlogin.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
