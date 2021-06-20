<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>图书管理系统登录</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg" body style="background-color:dodgerblue">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name"> Hi </h1>
        </div>
        <h3 style="color: antiquewhite;">欢迎使用Hi图书管理系统</h3>

        <form class="m-t" role="form" action="/login_admin" method="post" target="_parent">
            <div class="form-group">
                <input name="ID" type="tel" class="form-control" placeholder="管理员账号" required="">
            </div>
            <div class="form-group">
                <input name="password" type="password" class="form-control" placeholder="密码" required="">
            </div>
            <button  type="submit" class="btn btn-primary block full-width m-b" style="color: antiquewhite;">登 录</button>
        </form>
        <h3 style="color: red;">
            <%-- 获得从LoginServlet返回的请求，若返回请求则登录失败，执行警告--%>
            <%
                if(request.getAttribute("message")!= null){
                    out.print(request.getAttribute("message"));
                }
            %>
        </h3>
    </div>

        <a href="login.jsp" style="color: white;" target="_parent"> 返回读者登录 </a>
    </div>
</div>
</body>

</html>