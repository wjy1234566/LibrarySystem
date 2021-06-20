<%--
  Created by IntelliJ IDEA.
  User: MMJ
  Date: 2020/5/24
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <title>Hi图书馆主页</title>

  <!--[if lt IE 8]>
  <meta http-equiv="refresh" content="0;ie.html" />
  <![endif]-->

  <link rel="shortcut icon" href="favicon.ico">
  <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
  <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">
  <link href="css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <!-- src中放头像 -->
              <span><img src="../web/profile.jpg" alt="" /></span>
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <span class="clear">
                <!-- name里放用户的学号 -->
               <span class="block m-t-xs"><strong class="font-bold">
                  <%
                    out.print(request.getAttribute("StuID"));
                  %>
               </strong></span>
                </span>
            </a>
          </div>
          <div class="logo-element">Hi
          </div>
        </li>

        <%-- 设置session对话，将StuID传递给当前会话  --%>
        <%
          String StuID = (String) request.getAttribute("StuID");
          session.setAttribute("StuID",StuID);
        %>

        <li>
          <!-- 主页页面，关联的页面未设置 href后为关联的html的地址 -->
          <a class="J_menuItem" href=""><i class="fa fa-star"></i> <span class="nav-label">主页</span></a>
        </li>

        <li>
          <!-- 修改密码页面 -->
          <a class="J_menuItem" href="change_key.jsp" target="_parent" ><i class="fa fa-key"></i> <span class="nav-label">修改密码</span></a>
        </li>

        <li>
          <!-- 图书查询页面 -->
          <a class="J_menuItem" href="search_book.jsp" target="_parent"><i class="fa fa-book"></i> <span class="nav-label">图书查询</span></a>
        </li>

        <li>
          <!--  查看借阅界面，关联的页面未设置 -->
          <a class="J_menuItem" href="view_borrow_book.jsp" target="_parent" ><i class="fa fa-bookmark"></i> <span class="nav-label">查看借阅</span></a>
        </li>

        <li>
          <!--  预约管理界面，关联的页面未设置 -->
          <a class="J_menuItem" href="view_reservation_book.jsp" target="_parent"><i class="fa fa-tasks"></i> <span class="nav-label">查看预约</span></a>
        </li>

        <li>
          <!--  联系我们界面，关联的页面未设置 -->
          <a class="J_menuItem" href="feedback.jsp"><i class="fa fa-comments" target="_parent"></i> <span class="nav-label">联系我们</span></a>
        </li>

        <li>
          <!--  安全退出界面，关联的页面未设置 -->
          <a class="J_menuItem" href="login.jsp"><i class="fa fa-sign-out"></i> <span class="nav-label">安全退出</span></a>
        </li>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->


  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
          <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="main_page.jsp" frameborder="0"  seamless></iframe>
          </div>  </div>
      </nav>
    </div>
  </div>

  <!--右侧部分结束-->
</div>
</body>

</html>

