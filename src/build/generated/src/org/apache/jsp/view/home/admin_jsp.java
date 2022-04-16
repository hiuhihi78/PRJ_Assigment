package org.apache.jsp.view.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <!--bosstrap-->\n");
      out.write("        <link href=\"../../css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../../css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"../../js/home.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--bosstrap-->\n");
      out.write("\n");
      out.write("        <!--css-->\n");
      out.write("        <link href=\"../../css/stylehomeadmin.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!--css-->\n");
      out.write("\n");
      out.write("        <!--js-->\n");
      out.write("        <script src=\"../../js/home.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--js-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("\n");
      out.write("            <div class=\"menu\">\n");
      out.write("\n");
      out.write("                <div id=\"mySidenav\" class=\"sidenav\">\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;</a>\n");
      out.write("                    <a href=\"#\">Tài khoản</a>\n");
      out.write("                    <a href=\"#\">Đăng xuất</a>\n");
      out.write("                </div>\n");
      out.write("                <span id=\"open\" style=\"font-size:30px;cursor:pointer;\" onclick=\"openNav()\">&#9776; Menu</span>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--            <div id=\"logo\">\n");
      out.write("                            <a href=\"admin.jsp\"><img src=\"\"></a>\n");
      out.write("                        </div>-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <img src=\"../../images/banner.png\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("            <div class=\"row wellcome text-center\">\n");
      out.write("                <h2>Xin chào, <br> Chúc bạn có một ngày tốt lành!</h2>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation('#');\">Xuất hàng</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation('#');\">Nhập hàng</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation('#');\">Hóa Đơn</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation(\"\");\">Sản Phẩm</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation('#');\">Khách hàng</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4 navigation\">\n");
      out.write("                    <button onclick=\"doNavigation('#');\">Quản Lý tài khoản</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div id=\"footer\" class=\"text-center\">\n");
      out.write("                    <p>Email : NhanhHauCuQua@gmail.com</p>\n");
      out.write("                    <p>Address: La Tinh - Đông La - Hoài Đức - Hà Nội</p>\n");
      out.write("                    <h5>&copy; Copyright 2021. NhanhHauCuQua.com</h5>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("\n");
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
