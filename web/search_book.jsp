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


    <title>图书搜索</title>

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
                        <form action="/search" method="get">
                            <select id="searchType" name="searchType">
                                <option value=1>  书名  </option>
                                <option value=2>  ISBN  </option>
                                <option value=3>  作者  </option>
                                <option value=4>  出版社  </option>
                                <option value=5>  类别  </option>
                            </select>
                            <input type="text" placeholder="请输入要搜索的内容..." name="search" class="form-control input-lg">
                            <div class="input-group-btn">
                                <button class="btn btn-lg btn-primary" type="submit">
                                    搜索
                                </button>
                            </div>
                        </form>

                        <table class = "table" cellspacing="0">
                            <tr>
                                <td>ISBN</td>
                                <td>书名</td>
                                <td>作者</td>
                                <td>价格</td>
                                <td>出版社</td>
                                <td>馆藏数量</td>
                                <td>类别</td>
                                <td>封面</td>
                            </tr>
                            <c:forEach items="${list}" var="book">
                                <tr>
                                    <td>${book.bookID}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.author}</td>
                                    <td>${book.price}</td>
                                    <td>${book.publisher}</td>
                                    <td>${book.quantity}</td>
                                    <td>${book.bookClass}</td>
                                    <td>${book.bookSurface}</td>
                                    <td>
                                        <%-- 预约  向book_reservation传递bookID作为预约图书的书号 --%>
                                        <a href="/book_reservation?bookid=${book.bookID}" target="_parent">预约</a>
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