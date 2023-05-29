package HM.Controller.Selection;

import HM.DataObjects.User.SelectDAO;
import HM.Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class selectrole extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            
            String usermail = request.getParameter("usermail");
            String password = request.getParameter("password");
            
            SelectDAO selection = new SelectDAO(DatabaseConnection.getCon());
            
            String role = selection.selectUser(usermail,password);
            
            request.setAttribute("usermail",usermail);
            request.setAttribute("password",password);
            
            if(null == role)
                response.sendRedirect("login.html");
            else 
                               
                switch (role) 
                {
                    case "admin":
                        request.getRequestDispatcher("adminlog").forward(request, response);
                        break;
                    case "reception":
                        request.getRequestDispatcher("receptionlogin").forward(request, response);
                        break;
                    case "customer":
                        request.getRequestDispatcher("customerlogin").forward(request, response);
                        break;
                    default:
                        response.sendRedirect("login.html");
                        break;
                }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(selectrole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
