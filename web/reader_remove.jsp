<%@ page import="com.library.entity.BookEntity" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>读者注销</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="search-form">

                        <!-- 表单映射 -->
                        <form action="/reader_remove" method="get">
                            <input type="text" placeholder="学号" name="StuID" class="form-control input-lg">
                            <div class="hr-line-dashed"></div>
                               <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-lg btn-primary" type="submit">
                                        确定注销
                                    </button>
                                    <button class="btn btn-lg btn-white" onclick="javascrtpt:window.location.href='index_admin.jsp'">
                                        取消
                                    </button>
                                </div>
                            </div>
                        </form>
                        <h3 style="color: green;">
                            <%
                                if(request.getAttribute("remove_success")!= null){
                                    out.print(request.getAttribute("remove_success"));
                                }
                            %>
                        </h3>
                        <h3 style="color: red;">
                            <%
                                if(request.getAttribute("remove_err")!= null){
                                    out.print(request.getAttribute("remove_err"));
                                }
                            %>
                        </h3>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>