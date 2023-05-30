package HM.Controller.Booking;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class directtoform extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                int rid = Integer.parseInt(request.getParameter("rid"));
                String room_no = request.getParameter("room_no");
                String type = request.getParameter("type");
                String ac = request.getParameter("ac");
                
                String url = "bookingform.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(url);
                
                request.setAttribute("rid", rid);
                request.setAttribute("room_no", room_no);
                request.setAttribute("type", type);
                request.setAttribute("ac", ac);
                
                	
                rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
