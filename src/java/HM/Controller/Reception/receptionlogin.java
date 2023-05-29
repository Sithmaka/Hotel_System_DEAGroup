package HM.Controller.Reception;

import HM.Controller.Admin.adminlog;
import HM.DataObjects.Admin.AdminDAO;
import HM.DataObjects.Reception.ReceptionDAO;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Admin;
import HM.Model.Users.Reception;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class receptionlogin extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usermail = request.getParameter("usermail");
        String password = request.getParameter("password");
        
        try {
            
            ReceptionDAO recepdao = new ReceptionDAO(DatabaseConnection.getCon());
            
            Reception recep = recepdao.receptionLog(usermail,password);
            
            if(recep!=null){
                
                HttpSession session = request.getSession();
                
                session.setAttribute("loggedUser", recep);
                session.setAttribute("role","reception");
                
                String url = "/HotelManagement/View/JSP/reception/";
                response.sendRedirect(url + "receptiondashboard.jsp");
                
            }else{
                
                response.sendRedirect("login.html");
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(adminlog.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
