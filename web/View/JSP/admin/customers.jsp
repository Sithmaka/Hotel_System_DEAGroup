<%@page import="HM.Model.Users.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="HM.Database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <title>Customer</title>
    </head>
    <body>
        <h1>Customer</h1>
        <br>
        <a href="addcustomer.jsp">
            <button class="btn btn-primary">Add Customer</button>
        </a>
        <br>
        <br>
        <br>
        <%
            String query = "SELECT * FROM customer";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table class='table'>"
                        + "<thead>"
                            + "<tr>"
                            + "<th scope='col'></th>"
                            + "<th scope='col'>Username</th>"
                            + "<th scope='col'>Email</th>"
                            + "<th scope='col'>Password</th>"
                            + "<th scope='col'></th>"
                            + "<th scope='col'></th>"
                            + "</tr>"
                            + "</thead>"
                            + "<tbody>");
           

            while(rs.next()){
                
                int uid = rs.getInt("UID");
                String username = rs.getString("username");
                String user_mail = rs.getString("user_mail");
                String user_password = rs.getString("user_password");
                
                
                out.print("<tr>"
                        +"<form action='customerupdate' method='post'>"
                            + "<td>" + "<input type='hidden' class='form-control-plaintext' value='"+uid+"' name='uid' readonly> " + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+username+"' name='username' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+user_mail+"' name='usermail' readonly>" + "</td>"
                            + "<td>" + "<input type='password' class='form-control-plaintext' value='"+user_password+"' name='password' readonly>" + "</td>"
                            + "<td>" + "<input type='submit' class='btn btn-danger' value ='Delete' name='button'/>" + "</td>"
                            + "<td>" + "<input type='submit' class='btn btn-secondary' value ='Update' name='button'/>" + "</td>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</tbody>"
                    + "</table>"); 
        %>
    </body>
</html>