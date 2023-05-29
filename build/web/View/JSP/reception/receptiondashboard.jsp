<%@page import="java.sql.Connection"%>
<%@page import="HM.Model.Users.Reception"%>
<%@page import="HM.Database.DatabaseConnection"%>
<% 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    
%>
<% 
    Reception recep = (Reception) session.getAttribute("loggedUser");
    
    if(recep == null) {
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
    <title>Reception Dashboard</title>

    <link rel="stylesheet" href="../css/style-log.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <h3>Hi <span>Reception</span></h3>
            <h1>Welcome <span> <%= recep.getUsermail() %> </span></h1>
            <p>This is an reception page</p>
            <a href="./mang.php" class="btn">Management</a>
            <br>
            <form action="logout" method="post">
                <button type="submit" class="btn"> Log out </button>
            </form>
        </div>
    </div>
</body>
</html>
