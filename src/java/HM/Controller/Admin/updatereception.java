package HM.Controller.Admin;

import HM.DataObjects.Reception.UpdateReception;
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

public class updatereception extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("rid"));
            
            Reception uprecep = new Reception(id, usermail, password);
            
            UpdateReception updatedrecep = new UpdateReception(DatabaseConnection.getCon());
            
            if(updatedrecep.updateReception(uprecep)){
                
                response.sendRedirect("receptionstaff.jsp");
            }else{
                response.sendRedirect("updatereception.jsp");
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
