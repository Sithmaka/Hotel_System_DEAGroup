<%@page import="java.sql.Connection"%>
<%@page import="HM.Model.Users.Admin"%>
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>admin page</title>

    <link rel="stylesheet" href="../css/style-log.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <h3>Hi <span>admin</span></h3>
            <h1>Welcome <span> <%= admin.getUsermail() %> </span></h1>
            <p>This is an admin page</p>
            <a href="receptionstaff.jsp" class="btn">Reception Staff</a>
            <a href="customers.jsp" class="btn">Customers</a>
            <br>
            <form action="logout" method="post">
                <button type="submit" class="btn"> Log out </button>
            </form>
        </div>
    </div>
</body>
</html>
