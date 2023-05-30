package org.apache.jsp.View.JSP.booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import HM.Model.Users.Admin;
import java.sql.Connection;
import HM.Database.DatabaseConnection;

public final class bookingform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/Lin&Sup-style.css\">\n");
      out.write("        <title>Booking</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Book Now</h1>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <form action =\"addbooking\" id=\"log-in\" class=\"input-group\" method=\"post\">\n");
      out.write("            \n");
      out.write("            <input type=\"text\" class=\"input-field\"  name = \"username\" placeholder = \"Username\" required>\n");
      out.write("            \n");
      out.write("            <input type=\"text\" class=\"input-field\"  name = \"nic\" placeholder = \"NIC\" required>\n");
      out.write("            \n");
      out.write("            ");

                
                String room_no = request.getParameter("room_no");
                out.print("<input type='text' class='input-field' name = 'room_no' value='"+room_no+"' readonly required>");
                
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                
                String type = request.getParameter("type");
                out.print("<input type='text' class='input-field' name = 'type' value='"+type+"' readonly required>");
                
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                
                String ac = request.getParameter("ac");
                out.print("<input type='text' class='input-field' name = 'ac' value='"+ac+"' readonly required>");
                
            
      out.write("  \n");
      out.write("            \n");
      out.write("            <input type=\"datetime-local\" class=\"input-field\"  name = \"check_in\" required>\n");
      out.write("            \n");
      out.write("            <input type=\"datetime-local\" class=\"input-field\"  name = \"check_out\" required>\n");
      out.write("            \n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <button type=\"submit\" class=\"submit-btn\">Book</button>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
