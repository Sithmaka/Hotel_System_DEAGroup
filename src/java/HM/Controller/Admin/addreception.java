package HM.Controller.Admin;

import HM.DataObjects.Reception.AddNewReception;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Reception;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addreception extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            
            Reception newrecep = new Reception(usermail,password);
            
            AddNewReception addnewrecep = new AddNewReception(DatabaseConnection.getCon());
            
            if(addnewrecep.addReception(newrecep)){
                response.sendRedirect("receptionstaff.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(addreception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
