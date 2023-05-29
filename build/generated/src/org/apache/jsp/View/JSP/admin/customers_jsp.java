package org.apache.jsp.View.JSP.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HM.Model.Users.Admin;
import java.sql.Connection;
import HM.Database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public final class customers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\"\n");
      out.write("              rel=\"stylesheet\" \n");
      out.write("              integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" \n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        <title>Customer</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Customer</h1>\n");
      out.write("        <br>\n");
      out.write("        <a href=\"addcustomer.jsp\">\n");
      out.write("            <button class=\"btn btn-primary\">Add Customer</button>\n");
      out.write("        </a>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
