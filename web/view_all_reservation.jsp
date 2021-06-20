<%@ page import="com.library.entity.BookEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.servlet.AllReservationServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>全部预约</title>

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
                            <form action="/all_reservation" method="get">
                                <div class="input-group-btn">
                                    <button class="btn btn-lg btn-primary" type="submit">
                                        查询
                                    </button>
                                </div>
                            </form>
                        <table class = "table" cellspacing="0">
                            <tr>
                                <td>书号</td>
                                <td>读者号</td>
                                <td>预约日期</td>
                            </tr>
                            <c:forEach items="${list}" var="reservation">
                                <tr>
                                    <td>${reservation.stuID}</td>
                                    <td>${reservation.bookID}</td>
                                    <td>${reservation.reservationDate}</td>
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
