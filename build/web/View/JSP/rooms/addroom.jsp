<%@page import="HM.Model.Users.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="HM.Database.DatabaseConnection"%>
<% 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    
%>
<% 
    Admin admin = (Admin) session.getAttribute("loggedUser");
    
    if(admin == null) {
        response.sendRedirect("/HotelManagement/View/HTML/login.html");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/Lin&Sup-style.css">
        <title>Add Room</title>
    </head>
    <body>
        <h1>Add New Room</h1>
        <br>
        <br>
        <form action ="addroom" id="log-in" class="input-group" method="post">
                <select class="input-field" name="type" required>
                    <option value="" readonly>Select room type</option>
                    <option value="Single">Single</option>
                    <option value="Deluxe">Deluxe</option>
                </select>
            
                
                <select class="input-field" name="ac_status" required>
                    <option value="" readonly>Select AC status</option>
                    <option value="With AC">With AC</option>
                    <option value="Without AC">Without AC</option>
                </select>
                
                <input type="text" class="input-field"  name = "room_status" value = "Available" readonly required>
                
                <input type="text" class="input-field" placeholder="Room Number" name = "room_no" required>
                
                <br>
                <br>
                <button type="submit" class="submit-btn">Add</button>
        </form>
    </body>
</html>
