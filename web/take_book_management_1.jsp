<%@ page import="com.library.entity.BookEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.repository.BorrowBookRepository" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%
    String BookID = request.getParameter("BookID");
    String StuID = request.getParameter("StuID");
    String Flag = request.getParameter("Flag");
    BorrowBookRepository borrowBookRepository = new BorrowBookRepository();
    borrowBookRepository.addBorrow(StuID, BookID, Flag);
%>


<link rel=\"shortcut icon\ href=\"favicon.ico\"> <link href=\"css/bootstrap.min.css?v=3.3.5\" rel=\"stylesheet\">
 <link href=\"css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">
<link href=\"css/animate.min.css\" rel=\"stylesheet\">
    <link href=\"css/style.min.css?v=4.0.0\" rel=\"stylesheet\"><base target=\"_blank\">
<body>
        <table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">
             <tr>
                <td valign=\"middle\" align = \"center\">
            <h3 style = 'color:green'>取书成功！</h3> <button class="btn btn-primary block  m-b" style="color: antiquewhite" onclick="javascrtpt:window.location.href='take_book_management.jsp'">确定</button> </td>
                    </tr>
        </table>
</body>
</div>
