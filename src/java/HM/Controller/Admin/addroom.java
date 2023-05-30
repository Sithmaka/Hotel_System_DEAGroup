package HM.Controller.Admin;

import HM.DataObjects.Rooms.AddNewDeluxeRoom;
import HM.DataObjects.Rooms.AddNewSingleRoom;
import HM.Database.DatabaseConnection;
import HM.Model.Rooms.DeluxeRoom;
import HM.Model.Rooms.SingleRoom;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addroom extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String type = request.getParameter("type");
            String ac_status = request.getParameter("ac_status");
            String room_status = request.getParameter("room_status");
            String room_no = request.getParameter("room_no");
            
                if(type.equals("Single")){
                    
                    SingleRoom newroom = new SingleRoom(type, room_no, ac_status, room_status);

                    AddNewSingleRoom addnewroom = new AddNewSingleRoom(DatabaseConnection.getCon());

                    if(addnewroom.addSingleRoom(newroom)){
                        response.sendRedirect("singlerooms.jsp");
                    }else{
                        response.sendRedirect("addroom.jsp");
                    }
                }else{
                    DeluxeRoom newroom = new DeluxeRoom(type, room_no, ac_status, room_status);

                    AddNewDeluxeRoom addnewroom = new AddNewDeluxeRoom(DatabaseConnection.getCon());

                    if(addnewroom.addDeluxeRoom(newroom)){
                        response.sendRedirect("singlerooms.jsp");
                    }else{
                        response.sendRedirect("addroom.jsp");
                    }
                }
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(addcustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
