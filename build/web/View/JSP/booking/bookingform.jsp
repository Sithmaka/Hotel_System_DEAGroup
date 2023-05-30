<%@page import="HM.Model.Users.User"%>
<%@page import="HM.Model.Users.Customer"%>
<%@page import="HM.Model.Users.Reception"%>
<%@page import="HM.Model.Users.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="HM.Database.DatabaseConnection"%>
<% 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    
%>
<%
    User user = null;
    
    if("admin".equals(session.getAttribute("role"))){
        
        user = (Admin) session.getAttribute("loggedUser");
    }
    if("reception".equals(session.getAttribute("role"))){
        
        user = (Reception) session.getAttribute("loggedUser");
    }
    if("customer".equals(session.getAttribute("role"))){
        
        user = (Customer) session.getAttribute("loggedUser");
    }
     
   
    if(user == null) {
        response.sendRedirect("/HotelManagement/View/HTML/login.html");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/Lin&Sup-style.css">
        <title>Booking</title>
    </head>
    <body>
        <h1>Book Now</h1>
        <br>
        <br>
        <form action ="addbooking" id="log-in" class="input-group" method="post">
            
            <%
                Object o = request.getAttribute("rid");
                String id = o.toString();
                int rid = Integer.parseInt(id);
                out.print("<input type='hidden' class='input-field' name = 'rid' value='"+rid+"' readonly required>");
                
            %>
            
            <input type="text" class="input-field"  name = "usermail" placeholder = "UserMail" required>
            
            <input type="text" class="input-field"  name = "nic" placeholder = "NIC" required>
            
            <%
                
                String room_no = (String)request.getAttribute("room_no");
                out.print("<input type='text' class='input-field' name = 'room_no' value='"+room_no+"' readonly required>");
                
            %>
            
            <%
                
                String type = (String)request.getAttribute("type");
                out.print("<input type='text' class='input-field' name = 'type' value='"+type+"' readonly required>");
                
            %>
            
            <%
                
                String ac = (String)request.getAttribute("ac");
                out.print("<input type='text' class='input-field' name = 'ac' value='"+ac+"' readonly required>");
                
            %>  
            
            <input type="datetime-local" class="input-field"  name = "check_in" required>
            
            <input type="datetime-local" class="input-field"  name = "check_out" required>
            
                <br>
                <br>
                <button type="submit" class="submit-btn">Book</button>
        </form>
    </body>
</html>
