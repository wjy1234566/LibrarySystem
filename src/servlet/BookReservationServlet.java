package com.library.servlet;


import com.library.repository.BookReservationRepository;
import com.sun.deploy.util.SessionState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book_reservation")
public class BookReservationServlet extends HttpServlet {

    /*
    * service方法和doGet方法要一个就可以
    * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取预约的图书号
        String BookID = (String) req.getParameter("bookid");
        // 获取session中的StuID
        String StuID= (String) req.getSession().getAttribute("StuID");

        // 调用BookReservationRepository，将记录加入到预约表中
        BookReservationRepository bookReservationRepository = new BookReservationRepository();
        bookReservationRepository.bookReservation(StuID,BookID);

        // 返回预约成功到浏览器
        resp.setContentType("text/html;charset=utf-8");//设置编码格式，以防前端页面出现中文乱码
        resp.getWriter().write(
                " <link rel=\"shortcut icon\" href=\"favicon.ico\"> <link href=\"css/bootstrap.min.css?v=3.3.5\" rel=\"stylesheet\">\n" +
                        "    <link href=\"css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\n" +
                        "\n" +
                        "    <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n" +
                        "    <link href=\"css/style.min.css?v=4.0.0\" rel=\"stylesheet\"><base target=\"_blank\">" + " <body>\n" +
                        "        <table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "            <tr>\n" +
                        "                <td valign=\"middle\" align = \"center\">" +
                        "<h3 style = 'color:green'>预约成功！ 请在预约成功后七天内取书！</h3>" + "<button class=\"btn btn-primary block  m-b\" style=\"color: antiquewhite;\" onclick=\"javascrtpt:window.location.href='search_book.jsp'\">确定</button>" + "  </td>\n" +
                        "            </tr>\n" +
                        "        </table>" +
                "</div>\n" );
    }
}
