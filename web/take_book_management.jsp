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


    <title>读者取书</title>

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
                        <form action="/take_book_management" method="post">
                            <input type="text" placeholder="请输入读者号..." name="StuID" class="form-control input-lg">
                            <div class="input-group-btn">
                                <button class="btn btn-lg btn-primary" type="submit">
                                    搜索预约信息
                                </button>
                                <button class="btn btn-lg btn-white" onclick="javascrtpt:window.location.href='index_admin.jsp'">
                                    取消
                                </button>
                            </div>
                        </form>

                        <table class = "table" cellspacing="0">
                            <tr>
                                <td>书号</td>
                                <td>读者号</td>
                                <td>预约日期</td>
                            </tr>
                            <c:forEach items="${list}" var="book">
                                <tr>
                                    <td>${book.bookID}</td>
                                    <td>${book.stuID}</td>
                                    <td>${book.reservationDate}</td>
                                    <td>
                                        <%-- 读者取书 --%>
                                        <a href="take_book_management_1.jsp?BookID=${book.bookID}&StuID=${book.stuID}&Flag=${1}">读者取书</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%
                            if(request.getAttribute("message")!= null){
                                out.print(request.getAttribute("message"));
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>