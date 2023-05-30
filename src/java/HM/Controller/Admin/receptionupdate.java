package HM.Controller.Admin;

import HM.DataObjects.Reception.DeleteReception;
import HM.Database.DatabaseConnection;
import HM.Model.Users.Reception;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class receptionupdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int rid = Integer.parseInt(request.getParameter("rid"));
        String button = request.getParameter("button");
        
        Reception recep;
        DeleteReception dr;
        
        if(button.equals("Delete")){
            
            try {
                recep = new Reception(rid);
                dr = new DeleteReception(DatabaseConnection.getCon());
                
                if(dr.deleteReception(recep)){
                
                    response.sendRedirect("receptionstaff.jsp");
                    
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(receptionupdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else {
                
                String usermail = request.getParameter("usermail");
                String password = request.getParameter("password");
                
                String url = "updatereception.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                
                request.setAttribute("rid", rid);
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
