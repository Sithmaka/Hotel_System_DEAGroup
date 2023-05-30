package HM.Controller.Booking;

import HM.DataObjects.Booking.AddBooking;
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

public class addbooking extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            int rid = Integer.parseInt(request.getParameter("rid"));
            String usermail = request.getParameter("usermail");
            String nic = request.getParameter("nic");
            String room_no = request.getParameter("room_no");
            String type = request.getParameter("type");
            String ac = request.getParameter("ac");
            String check_in = request.getParameter("check_in");
            String check_out = request.getParameter("check_out");
            
            Booking booking = new Booking (rid, type, room_no, ac, usermail, nic, check_in, check_out);
            
            AddBooking addbooking = new AddBooking(DatabaseConnection.getCon());
            
            if(addbooking.addBooking(booking)){
                if(type.equals("Single")){
                    SingleRoom sr = new SingleRoom(rid);
                    
                    UpdateSingleRoomStatus update = new UpdateSingleRoomStatus(DatabaseConnection.getCon());
                    
                    update.updateRoomStatusSingle(sr);
                }else{
                    DeluxeRoom dr = new DeluxeRoom(rid);
                    
                    UpdateDeluxeRoomStatus update = new UpdateDeluxeRoomStatus(DatabaseConnection.getCon());
                    
                    update.updateRoomStatusDeluxe(dr);
                }
                response.sendRedirect("bookings.jsp");
            }else{
                response.sendRedirect("bookingform.jsp");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(addbooking.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
