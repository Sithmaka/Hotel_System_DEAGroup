package HM.Controller.Booking;

import HM.DataObjects.Booking.CancelBooking;
import HM.DataObjects.Booking.UpdateDeluxeRoomStatus;
import HM.DataObjects.Booking.UpdateSingleRoomStatus;
import HM.Database.DatabaseConnection;
import HM.Model.Booking.Booking;
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

public class cancelbooking extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            
            int bid = Integer.parseInt(request.getParameter("bid"));
            int rid = Integer.parseInt(request.getParameter("rid"));
            String type = request.getParameter("type");

            
            Booking booking = new Booking (bid, rid);
            
            CancelBooking cancelbooking = new CancelBooking(DatabaseConnection.getCon());
            
            if(cancelbooking.cancelBooking(booking)){
                if(type.equals("Single")){
                    SingleRoom sr = new SingleRoom(rid);
                    
                    UpdateSingleRoomStatus update = new UpdateSingleRoomStatus(DatabaseConnection.getCon());
                    
                    update.updateRoomStatusAvailable(sr);
                }else{
                    DeluxeRoom dr = new DeluxeRoom(rid);
                    
                    UpdateDeluxeRoomStatus update = new UpdateDeluxeRoomStatus(DatabaseConnection.getCon());
                    
                    update.updateRoomStatusAvailable(dr);
                }
                response.sendRedirect("bookings.jsp");
            }else{
                response.sendRedirect("bookings.jsp");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cancelbooking.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
