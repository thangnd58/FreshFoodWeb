package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wishlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!-- Basic Page Needs -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>FreshMart - Organic, Fresh Food, Farm Store HTML Template</title>\n");
      out.write("\n");
      out.write("        <meta name=\"keywords\" content=\"Organic, Fresh Food, Farm Store\">\n");
      out.write("        <meta name=\"description\" content=\"FreshMart - Organic, Fresh Food, Farm Store HTML Template\">\n");
      out.write("        <meta name=\"author\" content=\"tivatheme\">\n");
      out.write("\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.png\" type=\"image/png\">\n");
      out.write("\n");
      out.write("        <!-- Mobile Meta -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\n");
      out.write("        <!-- Google Fonts -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Playfair+Display:300,400,700\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Vendor CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/bootstrap/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/font-material/css/material-design-iconic-font.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/nivo-slider/css/nivo-slider.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/nivo-slider/css/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/nivo-slider/css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/owl.carousel/assets/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"libs/slider-range/css/jslider.css\">\n");
      out.write("\n");
      out.write("        <!-- Template CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/reponsive.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <header id=\"header\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header-top\">\n");
      out.write("                <div class=\"row align-items-center\">\n");
      out.write("                    <!-- Header Center -->\n");
      out.write("                    <div class=\"col-lg-12 col-md-12 col-sm-12 header-center justify-content-center\">\n");
      out.write("                        <!-- Logo -->\t\t\n");
      out.write("                        <div class=\"logo\">\n");
      out.write("                            <a href=\"home\">\n");
      out.write("                                <img class=\"img-responsive\" src=\"img/logo.png\" alt=\"Logo\">\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <span id=\"toggle-mobile-menu\"><i class=\"zmdi zmdi-menu\"></i></span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <body class=\"home home-1\">\n");
      out.write("        <div id=\"all\">\n");
      out.write("\n");
      out.write("            <!-- Main Content -->\n");
      out.write("            <div id=\"content\" class=\"site-content\">\n");
      out.write("                <!-- Breadcrumb -->\n");
      out.write("                <div class=\"container\" style=\"padding-top: 50px\">\n");
      out.write("                    <ul class=\"breadcrumb\">\n");
      out.write("                        <li><a href=\"home\" title=\"Home\">Trang chủ</a></li>\n");
      out.write("                        <li><span>Danh sách yêu thích</span></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"page-cart\">\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <h2 class=\"title text-center\">Danh sách yêu thích</h2>\n");
      out.write("                                <table class=\"cart-summary table table-bordered\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th class=\"width-20\">&nbsp;</th>\n");
      out.write("                                            <th class=\"width-80 text-center\">Ảnh</th>\n");
      out.write("                                            <th class=\"width-120\">Tên sản phẩm</th>\n");
      out.write("                                            <th class=\"width-100 text-center\">Giá</th>\n");
      out.write("                                            <th class=\"width-100 text-center\">Số lượng mua</th>\n");
      out.write("                                            <th class=\"width-100 text-center\">Số lượng sản phẩm</th>\n");
      out.write("                                            <th class=\"width-100 text-center\">Tổng tiền</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("\n");
      out.write("                                    <tbody>\n");
      out.write("                                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Vendor JS -->\n");
      out.write("            <script src=\"libs/jquery/jquery.js\"></script>\n");
      out.write("            <script src=\"libs/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("            <script src=\"libs/jquery.countdown/jquery.countdown.js\"></script>\n");
      out.write("            <script src=\"libs/nivo-slider/js/jquery.nivo.slider.js\"></script>\n");
      out.write("            <script src=\"libs/owl.carousel/owl.carousel.min.js\"></script>\n");
      out.write("            <script src=\"libs/slider-range/js/tmpl.js\"></script>\n");
      out.write("            <script src=\"libs/slider-range/js/jquery.dependClass-0.1.js\"></script>\n");
      out.write("            <script src=\"libs/slider-range/js/draggable-0.1.js\"></script>\n");
      out.write("            <script src=\"libs/slider-range/js/jquery.slider.js\"></script>\n");
      out.write("            <script src=\"libs/elevatezoom/jquery.elevatezoom.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Template CSS -->\n");
      out.write("            <script src=\"js/main.js\"></script>\n");
      out.write("        </body>\n");
      out.write("    </html>\n");
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
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getItems()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <tr>\n");
          out.write("                                                <td class=\"product-remove\">\n");
          out.write("                                                    <form action=\"process\" method=\"post\">\n");
          out.write("                                                        <input type=\"hidden\" name=\"pid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                        <button title=\"Delete\" class=\"remove\" style=\"border: none; background-color: white\" type=\"submit\">\n");
          out.write("                                                            <i class=\"fa fa-times\"></i>\n");
          out.write("                                                        </button>\n");
          out.write("                                                    </form>\n");
          out.write("                                                </td>\n");
          out.write("                                                <td>\n");
          out.write("                                                    <a href=\"detail?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                        <img width=\"80\" alt=\"Product Image\" class=\"img-responsive\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getImgURL1()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                    </a>\n");
          out.write("                                                </td>\n");
          out.write("                                                <td>\n");
          out.write("                                                    <a href=\"detail?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"product-name\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                                                </td>\n");
          out.write("                                                <td class=\"text-center\">\n");
          out.write("                                                    <span>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getOriginal()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" đ</span>\n");
          out.write("                                                </td>\n");
          out.write("                                                <td>\n");
          out.write("                                                    <div class=\"product-quantity\">\n");
          out.write("                                                        <div class=\"qty\">\n");
          out.write("                                                            <div class=\"input-group\">\n");
          out.write("                                                                <input type=\"text\" readonly name=\"qty\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" min=\"1\" max=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                                <span class=\"adjust-qty\">\n");
          out.write("                                                                    <span class=\"adjust-btn plus\"><a href=\"process?num=1&pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">+</a></span>\n");
          out.write("                                                                    <span class=\"adjust-btn minus\"><a href=\"process?num=-1&pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getProductID()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">-</a></span>\n");
          out.write("                                                                </span>\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </div>\n");
          out.write("                                                </td>\n");
          out.write("                                                <td class=\"text-center\">\n");
          out.write("                                                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProduct().getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                                </td>\n");
          out.write("                                                <td>\n");
          out.write("                                                    <div class=\"product-quantity\">\n");
          out.write("                                                        <div class=\"qty\">\n");
          out.write("                                                            <div class=\"input-group\">\n");
          out.write("                                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart.getSubMoney(i.getProduct().getProductID())}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" đ\n");
          out.write("                                                            </div>\n");
          out.write("                                                        </div>\n");
          out.write("                                                    </div>\n");
          out.write("                                                </td>\n");
          out.write("                                            </tr>\n");
          out.write("                                        ");
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
