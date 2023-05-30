<%@page import="HM.Model.Users.User"%>
<%@page import="HM.Model.Users.Reception"%>
<%@page import="HM.Model.Users.Admin"%>
<%@page import="HM.Model.Users.Customer"%>
<%@page import="java.sql.Connection"%>
<%@page import="HM.Database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <title>Bookings</title>
    </head>
    <body>
        <h1>Bookings</h1>
        <br>
        <br>
        <%
            String query;
            PreparedStatement ps;
            if("admin".equals(session.getAttribute("role")) || "reception".equals(session.getAttribute("role"))){
                
                query = "SELECT * FROM booking";
                ps = con.prepareStatement(query);
                
            } else{
                query = "SELECT * FROM booking WHERE user_mail=?";
                
                ps = con.prepareStatement(query);
                ps.setString(1,user.getUsermail());
            }
            
            
            
            
            
            ResultSet rs = ps.executeQuery();
            
            out.print("<table class='table'>"
                        + "<thead>"
                            + "<tr>"
                            + "<th scope='col'></th>"
                            + "<th scope='col'></th>"
                            + "<th scope='col'>Room Number</th>"
                            + "<th scope='col'>Type</th>"
                            + "<th scope='col'>AC</th>"
                            + "<th scope='col'>Check IN</th>"
                            + "<th scope='col'>Check OUT</th>"
                            + "</tr>"
                            + "</thead>"
                            + "<tbody>");
           

            while(rs.next()){
                
                int bid = rs.getInt("BID");
                int rid = rs.getInt("room_id");
                String room_no = rs.getString("room_no");
                String type = rs.getString("type");
                String ac = rs.getString("ac_status");
                String check_in = rs.getString("check_in");
                String check_out = rs.getString("check_out");
                
                
                out.print("<tr>"
                        +"<form action='cancelbooking' method='post'>"
                            + "<td>" + "<input type='hidden' class='form-control-plaintext' value='"+bid+"' name='bid' readonly> " + "</td>"
                            + "<td>" + "<input type='hidden' class='form-control-plaintext' value='"+rid+"' name='rid' readonly> " + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+room_no+"' name='room_no' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+type+"' name='type' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+ac+"' name='ac' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+check_in+"' name='check_in' readonly>" + "</td>"
                            + "<td>" + "<input type='text' class='form-control-plaintext' value='"+check_out+"' name='check_out' readonly>" + "</td>"
                            + "<td>" + "<input type='submit' class='btn btn-danger' value ='Cancel' name='button'/>" + "</td>"
                        +"</form>"
                        +"</tr>");
            }
            
            out.print("</tbody>"
                    + "</table>"); 
        %>
    </body>
</html>
