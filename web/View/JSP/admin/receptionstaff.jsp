<%@page import="HM.Model.Users.Admin"%>
<%@page import="HM.Database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

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
        <title>Reception Staff</title>
    </head>
    <body>
        <h1>Reception Staff</h1>
        <br>
        <a href="addreception.jsp">
            <button class="btn btn-primary">Add Reception</button>
        </a>
        <br>
        <br>
        <br>
        <%
            String query = "SELECT * FROM reception";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table class='table'>"
                        + "<thead>"
                    + "<tr>"
                    + "<th scope='col'></th>"
                    + "<th scope='col'>Email</th>"
                    + "<th scope='col'>Password</th>"
                    + "<th scope='col'></th>"
                    + "<th scope='col'></th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
           

            while(rs.next()){
                
                int rid = rs.getInt("RID");
                String r_mail = rs.getString("r_mail");
                String r_password = rs.getString("r_password");
                
                
                out.print("<tr>"
                        +"<form action='receptionupdate' method='post'>"
                            + "<td>" + "<input type='hidden' class='form-control-plaintext' value='"+rid+"' name='rid' readonly> " + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+r_mail+"' name='usermail' readonly>" + "</td>"
                            + "<td>" + "<input type='password' class='form-control-plaintext' value='"+r_password+"' name='password' readonly>" + "</td>"
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
