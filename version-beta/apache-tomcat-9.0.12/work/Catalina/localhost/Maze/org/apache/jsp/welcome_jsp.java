/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-11-01 16:13:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import variables.Tag;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/imports/imports_general.jsp", Long.valueOf(1539871258000L));
    _jspx_dependants.put("/imports/imports_javascript.jsp", Long.valueOf(1539867300000L));
    _jspx_dependants.put("/imports/imports_css.jsp", Long.valueOf(1539775734000L));
    _jspx_dependants.put("/components/header.jsp", Long.valueOf(1539787650000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1539784228000L));
    _jspx_dependants.put("jar:file:/C:/Users/donle/Projects/maze-engagement/version-beta/apache-tomcat-9.0.12/webapps/Maze/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153381482000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("variables.Tag");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    ");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/all.min.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/external/bootstrap.css\">");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/welcome.css\">\n");
      out.write("    ");
      out.write("<script type=\"text/javascript\" src=\"resources/js/libs/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/libs/popper.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/libs/utils.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/external/bootstrap.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/vars/variables.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/vars/game.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/vars/grids.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/libs/grid-support.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/funcs/init-grid.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/funcs/instructions.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/funcs/validate.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/external/handlebars.runtime-v4.0.12.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/vars/templates.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/main.js\"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"resources/js/pages/welcome.js\"></script>\n");
      out.write("    <title>Kainos Maze</title>\n");
      out.write("</head>\n");
      out.write("<body> \n");
      out.write("\t<!-- IMPORT -->\n");
      out.write("\t");
      out.write("  \n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- HEADER -->\n");
      out.write("    ");
      out.write("<div class=\"kainos_header\">\n");
      out.write("     <a id=\"logo\" href=\"");
      out.print(Tag.path_root);
      out.write("\"><img src=\"resources/img/logorgbonline.png\"/></a>\n");
      out.write("     <div id=\"toolbar\">\n");
      out.write("     ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      <div>\n");
      out.write("      \t<a href=\"");
      out.print(Tag.path_board);
      out.write("\">\n");
      out.write("\t      \t<button class=\"btn btn-lg btn-default\" type=\"button\">\n");
      out.write("\t      \t\t<i class=\"fas fa-trophy text-warning\"></i>\n");
      out.write("\t      \t</button> \n");
      out.write("\t    </a>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write(" </div>");
      out.write("\n");
      out.write("    \n");
      out.write("    <!--\n");
      out.write("    <div class=\"bg\">\n");
      out.write("        <video autoplay muted loop class=\"fullscreen_bgvideo\">\n");
      out.write("                <source src=\"https://cdn1.kainos.com/assets/Kainos-Background-Video2-010d1914328ccf4ce1c86c34537f815f8d4c332a669057e88c67848c59f4b887.mp4\" type=\"video/mp4\">\n");
      out.write("                <source src=\"https://cdn1.kainos.com/assets/Kainos-Background-Video2-6d99ad2e5647c9a9838fda52dbf4d374da77433fef1f79df580fb83eef821973.webm\" type=\"video/webm\">\n");
      out.write("                <source src=\"https://cdn1.kainos.com/assets/Kainos-Background-Video2.dream.theora-bbfe80e0f4bc729fbc9c56f5270cc2f3869235e35dc890b9fd6c988afb63f367.ogv\" type=\"video/ogg\">\n");
      out.write("        </video>\n");
      out.write("    </div>-->\n");
      out.write("    <div class=\"welcome_container\">\n");
      out.write("        <div id=\"welcome\">\n");
      out.write("            <div class=\"title\"><span>Instructions</span></div>\n");
      out.write("            <div class=\"instructions\">\n");
      out.write("                Solve the maze using the given instructions. Each instruction should be written on a different line\n");
      out.write("                as shown in the example below. Note that each instruction can only be used twice. Time will start when you click play!\n");
      out.write("            </div>\n");
      out.write("            <div class=\"example\">\n");
      out.write("              <span><b>move left</b> (rotates arrow left 90 degrees and then move forward one step)</span><br>\n");
      out.write("              <span><b>move right</b> (rotates arrow right 90 degrees and then move forward one step)</span><br>\n");
      out.write("              <span><b>move forward</b> (arrow will move forward one step)</span><br>\n");
      out.write("              <span><b>jump left</b> (rotates arrow left 90 degrees and then jump forward two steps)</span><br>\n");
      out.write("              <span><b>jump right</b> (rotates arrow right 90 degrees and then jump forward two steps)</span><br>\n");
      out.write("              <span><b>jump forward</b> (jump forward two steps)</span><br>\n");
      out.write("              <span><b>repeat</b> (repeats previous commands in order x 3)</span><br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"run\">\n");
      out.write("\t\t\t    ");
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      boolean _jspx_th_c_005fchoose_005f0_reused = false;
      try {
        _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fchoose_005f0.setParent(null);
        int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
        if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\t\t\t    \t");
            //  c:when
            org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
            boolean _jspx_th_c_005fwhen_005f0_reused = false;
            try {
              _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
              _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
              // /welcome.jsp(47,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
              _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.username}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
              int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
              if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("\t\t\t    \t\t<a href=\"");
                  out.print(Tag.path_level1);
                  out.write("\" class=\"btn btn-lg\">Play</a> \n");
                  out.write("\t\t\t    \t");
                  int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
              _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
              _jspx_th_c_005fwhen_005f0_reused = true;
            } finally {
              org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
            }
            out.write("\n");
            out.write("\t\t\t    \t");
            if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
              return;
            out.write(" \n");
            out.write("\t            ");
            int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
        _jspx_th_c_005fchoose_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
      }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /components/header.jsp(4,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.username}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t     <div id=\"profile\" class=\"dropdown\">\n");
          out.write("\t      \t<button class=\"btn btn-lg btn-default dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
          out.write("\t      \t\t<i class=\"fas fa-user-circle\"></i>\n");
          out.write("\t      \t\t<span class=\"caret\"></span>\n");
          out.write("\t      \t</button>\n");
          out.write("\t      \t<div class=\"dropdown-menu dropdown-menu-right\" role=\"menu\" aria-labelledby=\"profile\">\n");
          out.write("\t      \t\t<button class=\"dropdown-item\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</button>\n");
          out.write("\t      \t\t<button id=\"signout\" class=\"dropdown-item\">Sign out</button>\n");
          out.write("\t      \t</div>\n");
          out.write("\t      </div>\n");
          out.write("      ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f0_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t            \t<input type=\"text\" class=\"form-control form-control-lg\" name=\"username\" required placeholder=\"Please enter your username here\"/>\n");
          out.write("\t\t                <button id=\"play\" class=\"btn btn-lg\">Play</button>\n");
          out.write("\t            \t");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      _jspx_th_c_005fotherwise_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
    }
    return false;
  }
}