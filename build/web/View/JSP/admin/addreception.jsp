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
        <title>Add Reception</title>
    </head>
    <body>
        <h1>Add New Reception</h1>
        <br>
        <br>
        <form action ="addreception" id="log-in" class="input-group" method="post">
                <input type="text" class="input-field" placeholder="Usermail" name = "usermail" required>
                <input type="password" class="input-field" placeholder="Password" name = "password" required>
                <br>
                <br>
                <button type="submit" class="submit-btn">Add</button>
        </form>
    </body>
</html>
