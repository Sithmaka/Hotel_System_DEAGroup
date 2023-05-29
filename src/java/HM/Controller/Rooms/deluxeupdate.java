package HM.Controller.Rooms;

import HM.DataObjects.Rooms.DeleteDeluxeRoom;
import HM.Database.DatabaseConnection;
import HM.Model.Rooms.DeluxeRoom;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deluxeupdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int rid = Integer.parseInt(request.getParameter("rid"));
        String button = request.getParameter("button");
        
        DeluxeRoom room;
        DeleteDeluxeRoom dsr;
        
        if(button.equals("Delete")){
            
            try {
                room = new DeluxeRoom(rid);
                dsr = new DeleteDeluxeRoom(DatabaseConnection.getCon());
                
                if(dsr.deleteSingleRoom(room)){
                
                    response.sendRedirect("deluxerooms.jsp");
                    
                }
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(deluxeupdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
