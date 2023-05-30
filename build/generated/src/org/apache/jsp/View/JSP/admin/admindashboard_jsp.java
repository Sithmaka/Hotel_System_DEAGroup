package org.apache.jsp.View.JSP.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import HM.Model.Users.Admin;
import HM.Database.DatabaseConnection;

public final class admindashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
    DatabaseConnection dbc = new DatabaseConnection ();
    
    Connection con = dbc.getCon();
    

      out.write('\n');
 
    Admin admin = (Admin) session.getAttribute("loggedUser");
    
    if("null".equals(admin)) {
        response.sendRedirect("/HotelManagement/View/HTML/login.html");
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>admin page</title>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/style-log.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <h3>Hi <span>admin</span></h3>\n");
      out.write("            <h1>Welcome <span> ");
      out.print( admin.getUsermail() );
      out.write(" </span></h1>\n");
      out.write("            <p>This is an admin page</p>\n");
      out.write("            <a href=\"receptionstaff.jsp\" class=\"btn\">Reception Staff</a>\n");
      out.write("            <a href=\"customers.jsp\" class=\"btn\">Customers</a>\n");
      out.write("            <a href=\"/HotelManagement/View/JSP/rooms/viewrooms.jsp\" class=\"btn\">Rooms</a>\n");
      out.write("            <a href=\"/HotelManagement/View/JSP/booking/bookings.jsp\" class=\"btn\">Bookings</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"logout\" method=\"post\">\n");
      out.write("                <button type=\"submit\" class=\"btn\"> Log out </button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
