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
        <title>Update Customer</title>
    </head>
    <body>
        <h1>Update Customer</h1>
        <br>
        <br>
        <form action ="updatecustomer" id="log-in" class="input-group" method="post">
            <%
                Object oid = request.getAttribute("uid");
                String uid = oid.toString();
                int id = Integer.valueOf(uid);
                out.print("<input type='hidden' name='uid' class='input-field' value='"+uid+"'/>");
            %>
            <%
                
                String username = request.getParameter("username");
                out.print("<input type='text' class='input-field' name = 'username' value='"+username+"' required>");
                
            %>
            <%
                
                String usermail = request.getParameter("usermail");
                out.print("<input type='text' class='input-field' name = 'usermail' value='"+usermail+"' required>");
                
            %>
            <%
                
                String password = request.getParameter("password");
                out.print("<input type='password' class='input-field' name = 'password' value='"+password+"' required>");
                
            %>
                <br>
                <br>
                <button type="submit" class="submit-btn">Update</button>
        </form>
    </body>
</html>
