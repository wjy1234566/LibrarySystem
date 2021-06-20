<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>Hi图书馆管理员主页</title>

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
                        <span><img alt="image" class="img-circle" src="web\profile.jpg" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                <!-- name里放用户的姓名 -->
                                    <span class="block m-t-xs"><strong class="font-bold"> 管理员 </strong></span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">Hi
                    </div>
                </li>


                <%--  借阅管理 --%>
                <li>
                    <a href="#">
                        <i class="fa fa-star"></i>
                        <span class="nav-label">借阅管理</span>
                    </a>
                    <ul class="nav nav-second-level" class="dropdown-menu animated fadeInRight m-t-xs">
                        <li>
                            <a class="J_menuItem" href="borrow_book.jsp" target="_parent">借书管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="return_book.jsp" target="_parent">还书管理</a>
                        </li>
                    </ul>

                </li>

                <li>
                    <!--  预约管理界面，关联的页面未设置 -->
                <li>
                    <a href="#">
                        <i class="fa fa-tasks"></i>
                        <span class="nav-label">预约管理</span> <span class="fa arrow"></span>
                    </a>  <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="view_all_reservation.jsp" target="_parent">查看所有预约</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="take_book_management.jsp" target="_parent">读者取书</a>
                        </li>
                    </ul>
                </li>


            <%--  读者信息管理 --%>
                <li>
                    <a href="#">
                        <i class="fa fa-cubes"></i>
                        <span class="nav-label">读者信息管理</span> <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="reader_register.jsp" target="_parent">注册读者</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="reader_remove.jsp" target="_parent">注销读者</a>
                        </li>
                    </ul>
                </li>

                <%--  书籍管理 --%>
                <li>
                    <a href="#">
                        <i class="fa fa-book"></i>
                        <span class="nav-label">书籍管理</span>
                    </a>
                    <ul class="nav nav-second-level" class="dropdown-menu animated fadeInRight m-t-xs">
                        <li>
                            <a class="J_menuItem" href="book_register.jsp" target="_parent">增加图书</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="book_remove.jsp" target="_parent">删除图书</a>
                        </li>
                    </ul>

                </li>


                <li>
                    <!--  留言管理，关联的页面未设置 -->
                    <a class="J_menuItem" href="get_feedback.jsp" target="_parent"><i class="fa fa-comment"></i> <span class="nav-label">读者反馈</span></a>
                </li>

                <li>
                    <!--  安全退出界面，关联的页面未设置 -->
                    <a class="J_menuItem" href="login_admin.jsp" target="_parent"><i class="fa fa-sign-out"></i> <span class="nav-label">安全退出</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->


    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <!-- 首页展示 src 后为首页的路径-->
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="borrow_book.jsp"  frameborder="0"  seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
</body>

</html>