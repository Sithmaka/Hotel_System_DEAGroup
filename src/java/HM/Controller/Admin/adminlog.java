package HM.Controller.Admin;

import HM.DataObjects.Admin.AdminDAO;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Admin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class adminlog extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String usermail = request.getParameter("usermail");
        String password = request.getParameter("password");
        
        try {
            
            AdminDAO admindao = new AdminDAO(DatabaseConnection.getCon());
            
            Admin admin = admindao.adminLog(usermail,password);
            
            if(admin!=null){
                
                HttpSession session = request.getSession();
                
                session.setAttribute("loggedUser", admin);
                session.setAttribute("role","admin");
                
                String url = "/HotelManagement/View/JSP/admin/";
                response.sendRedirect(url + "admindashboard.jsp");
                
            }else{
                
                response.sendRedirect("login.html");
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(adminlog.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
