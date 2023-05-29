package org.apache.jsp.View.JSP.reception;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import HM.Model.Users.Reception;
import java.sql.Connection;
import HM.Database.DatabaseConnection;

public final class viewprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
 
    DatabaseConnection dbc = new DatabaseConnection();
    Connection con = dbc.getCon();

      out.write('\n');
 
    Reception recep = (Reception) session.getAttribute("loggedUser");
    String userEmail = recep.getUsermail();

    if (recep == null) {
        response.sendRedirect("/HotelManagement/View/HTML/login.html");
    }

    // Retrieve reception data from the database
    try {
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM reception WHERE r_mail = ?");
        stmt.setString(1, userEmail);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("RID");
            String usermail = rs.getString("r_mail");
            String password = rs.getString("r_password");

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
      out.write("        <link rel=\"stylesheet\" href=\"../css/Lin&Sup-style.css\">\n");
      out.write("        <title>View Profile</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Profile</h1>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <table class=\"table\">\n");
      out.write("            <form action=\"updatereceptionprofile\" id=\"log-in\" class=\"input-group\" method=\"post\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <label for=\"rid\" class=\"form-label\">ID:</label>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type='number' id='form3Example8' name='rid' class='input-field' value='");
      out.print( id );
      out.write("' readonly/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <label for=\"r_mail\" class=\"form-label\">Email:</label>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type='text' class='input-field' name='usermail' value='");
      out.print( usermail );
      out.write("' required>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <label for=\"r_password\" class=\"form-label\">Password:</label>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type='password' class='input-field' name='password' value='");
      out.print( password );
      out.write("' required>\n");
      out.write("                    </td>\n");
      out.write("                </tr> \n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <button type=\"submit\" class=\"submit-btn\">Update</button>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");

        } else {
            response.sendRedirect("receptiondashboard.jsp");
        }

        stmt.close();
    } catch (SQLException e) {
        // Handle database exception
        e.printStackTrace();
    }

      out.write('\n');
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
