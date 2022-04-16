package org.apache.jsp.view.order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"../js/pagger.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" \n");
      out.write("              integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\"\n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"../css/export/viewInvoice.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../css/order/search.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #efecec;\">\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid \">\n");
      out.write("            <div class=\"row text-center header\">\n");
      out.write("                <a id=\"btn-home\" class=\"btn btn-lg\" href=\"../home\">\n");
      out.write("                    <i class=\"fa fa-home fa-2x\" aria-hidden=\"true\"></i>\n");
      out.write("                    <span style=\"font-weight: bold;\">Home</span>\n");
      out.write("                </a>    \n");
      out.write("                <h2 id=\"title\">Hóa đơn</h2>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-2\"></div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <form action=\"search\" style=\"position: relative; left: 20%;\">\n");
      out.write("\n");
      out.write("                    <b id=\"orderId\">Mã số hóa đơn:</b> \n");
      out.write("                    <input class=\"input\" type=\"number\" name=\"orderID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.orderID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-toggle=\"collapse\" data-target=\"#advantageSearch\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-menu-down\" aria-hidden=\"true\"></span> Nâng cao\n");
      out.write("                    </button>\n");
      out.write("                    \n");
      out.write("                    <input type=\"submit\" class=\"btn btn-info\" value=\"Tìm kiếm\">\n");
      out.write("                    \n");
      out.write("                    <div id=\"advantageSearch\" class=\"collapse\">\n");
      out.write("                        <p>\n");
      out.write("                            <b id=\"cId\">Mã số khách hàng:</b> \n");
      out.write("                            <input class=\"input\" type=\"number\" name=\"customerID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.customerID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <b id=\"cName\">Tên khách hàng:</b> \n");
      out.write("                            <input class=\"input\" type=\"text\" name=\"customerName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.customerName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <b>Từ</b> \n");
      out.write("                            <input class=\"input\" type=\"date\" name=\"dateFrom\" min=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.dateFromset}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" max=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.currentDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.dateFrom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                            <b>Đến</b> \n");
      out.write("                            <input class=\"input\" type=\"date\" name=\"dateTo\" max=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.currentDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.dateTo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br>\n");
      out.write("                        </p>\n");
      out.write("                        <p>\n");
      out.write("                            <b id=\"seller\">Người bán:</b>\n");
      out.write("                            <input class=\"input\" type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row\" style=\"margin-top: 30px;\">\n");
      out.write("            <div class=\"col-md-2\"></div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <table class=\"table table-bordered  text-center table-hover\">\n");
      out.write("                    <tr style=\"background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(253,187,45,1) 100%); color: white; font-size: 15px;\">\n");
      out.write("                        <th>Mã số hóa đơn</th>\n");
      out.write("                        <th>Mã số khách hàng</th>\n");
      out.write("                        <th>Tên khách hàng</th>\n");
      out.write("                        <th>Thời gian</th>\n");
      out.write("                        <th>Tổng tiền cẩn trả</th>\n");
      out.write("                        <th>Số tiền đã trả</th>\n");
      out.write("                        <th>Người bán</th>\n");
      out.write("                        <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </table>\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"pagger\"></div>\n");
      out.write("        <script>\n");
      out.write("            if (");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.totalPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" > 1) {\n");
      out.write("                createPage('pagger', ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.page}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", 2,");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.totalPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(");\n");
      out.write("            }\n");
      out.write("        </script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.orders}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("o");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <tr>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.customer.person.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.customer.person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.paid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.seller.displayname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td><a href=\"detail?orderId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">Chi tiết</a></td>\n");
          out.write("                        </tr>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
