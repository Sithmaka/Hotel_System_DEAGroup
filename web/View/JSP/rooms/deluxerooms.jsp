<%@page import="HM.Model.Users.Admin"%>
<%@page import="java.sql.Connection"%>
<%@page import="HM.Database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<% 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    
%>

<%-- 
    Admin admin = (Admin) session.getAttribute("loggedUser");
    
    if(admin == null) {
        response.sendRedirect("/HotelManagement/View/HTML/login.html");
    }

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <title>Deluxe Rooms</title>
    </head>
    <body>
        <h1>Deluxe Rooms</h1>
        <br>
        <a href="addroom.jsp">
            <button class="btn btn-primary">Add Room</button>
        </a>
        <br>
        <br>
        <br>
        <%
            String query = "SELECT * FROM deluxeroom";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table class='table'>"
                        + "<thead>"
                            + "<tr>"
                            + "<th scope='col'></th>"
                            + "<th scope='col'>Room Number</th>"
                            + "<th scope='col'>Type</th>"
                            + "<th scope='col'>AC</th>"
                            + "<th scope='col'>Status</th>"
                            + "</tr>"
                            + "</thead>"
                            + "<tbody>");
           

            while(rs.next()){
                
                int rid = rs.getInt("RoomID");
                String room_no = rs.getString("room_no");
                String type = rs.getString("type");
                String ac = rs.getString("ac_status");
                String roomstatus = rs.getString("room_status");
                
                
                out.print("<tr>"
                        +"<form action='deluxeupdate' method='post'>"
                            + "<td>" + "<input type='hidden' class='form-control-plaintext' value='"+rid+"' name='rid' readonly> " + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+room_no+"' name='room_no' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+type+"' name='type' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+ac+"' name='ac' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+roomstatus+"' name='ac' readonly>" + "</td>"
                            + "<td>" + "<input type='submit' class='btn btn-danger' value ='Delete' name='button'/>" + "</td>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</tbody>"
                    + "</table>"); 
        %>
    </body>
</html>