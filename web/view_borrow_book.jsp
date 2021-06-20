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


    <title>查看借阅</title>

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
                        <form action="/view_borrow_book" method="get">
                            <div class="input-group-btn">
                                <button class="btn btn-lg btn-primary" type="submit">
                                    刷新
                                </button>
                            </div>
                        </form>

                        <h2 style="color: green;">
                            当前借阅
                        </h2>
                        <table class = "table" cellspacing="0">
                            <tr>
                                <td>书号</td>
                                <td>书名</td>
                                <td>出版社</td>
                                <td>到期日期</td>
                            </tr>
                            <c:forEach items="${now_borrow_book}" var="now_book">
                                <tr>
                                    <td>${now_book.bookID}</td>
                                    <td>${now_book.bookName}</td>
                                    <td>${now_book.publisher}</td>
                                    <td>${now_book.dueDate}</td>
                                    <td>
                                        <%-- 续借 --%>
                                        <a href="/renew_book?BookID=${now_book.bookID}" target="_parent">续借</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <h2 style="color: red;">
                        <%
                            if(request.getAttribute("renew")!= null){
                                out.print(request.getAttribute("renew"));
                            }
                        %>
                        </h2>

                    </div>

                    <h2 style="color: green;">
                        历史借阅
                    </h2>
                    <table class = "table" cellspacing="0">
                        <tr>
                            <td>书号</td>
                            <td>书名</td>
                            <td>出版社</td>
                            <td>归还日期</td>
                        </tr>
                        <c:forEach items="${his_borrow_book}" var="history_book">
                            <tr>
                                <td>${history_book.bookID}</td>
                                <td>${history_book.bookName}</td>
                                <td>${history_book.publisher}</td>
                                <td>${history_book.returnDate}</td>
                            </tr>
                        </c:forEach>
                    </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>