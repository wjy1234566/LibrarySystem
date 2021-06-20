package com.library.servlet;

import com.library.repository.RenewBookRepository;
import com.library.repository.ReturnBookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/renew_book")
public class RenewBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StuID = (String) req.getSession().getAttribute("StuID");
        String BookID = req.getParameter("BookID");
        RenewBookRepository renewBookRepository = new RenewBookRepository();
        boolean check = renewBookRepository.renewBook(StuID,BookID);
        resp.setContentType("text/html;charset=utf-8");//设置编码格式，以防前端页面出现中文乱码
//设置编码格式，以防前端页面出现中文乱码
        if (check) {
            // 返回续借成功到浏览器
            resp.getWriter().write(
                    " <link rel=\"shortcut icon\" href=\"favicon.ico\"> <link href=\"css/bootstrap.min.css?v=3.3.5\" rel=\"stylesheet\">\n" +
                            "    <link href=\"css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\n" +
                            "\n" +
                            "    <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n" +
                            "    <link href=\"css/style.min.css?v=4.0.0\" rel=\"stylesheet\"><base target=\"_blank\">" + " <body>\n" +
                            "        <table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "            <tr>\n" +
                            "                <td valign=\"middle\" align = \"center\">" +
                            "<h3 style = 'color:green'>续借成功！</h3>" + "<button class=\"btn btn-primary block  m-b\" style=\"color: antiquewhite;\" onclick=\"javascrtpt:window.location.href='view_borrow_book.jsp'\">确定</button>" + "  </td>\n" +
                            "            </tr>\n" +
                            "        </table>" +
                            "</div>\n" );
        }else {
            // 续借失败
            resp.getWriter().write(
                    " <link rel=\"shortcut icon\" href=\"favicon.ico\"> <link href=\"css/bootstrap.min.css?v=3.3.5\" rel=\"stylesheet\">\n" +
                            "    <link href=\"css/font-awesome.min.css?v=4.4.0\" rel=\"stylesheet\">\n" +
                            "\n" +
                            "    <link href=\"css/animate.min.css\" rel=\"stylesheet\">\n" +
                            "    <link href=\"css/style.min.css?v=4.0.0\" rel=\"stylesheet\"><base target=\"_blank\">" + " <body>\n" +
                            "        <table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                            "            <tr>\n" +
                            "                <td valign=\"middle\" align = \"center\">" +
                            "<h3 style = 'color:red'>续借失败！已无剩余续借次数！</h3>" + "<button class=\"btn btn-primary block  m-b\" style=\"color: antiquewhite;\" onclick=\"javascrtpt:window.location.href='view_borrow_book.jsp'\">确定</button>" + "  </td>\n" +
                            "            </tr>\n" +
                            "        </table>" +
                            "</div>\n" );
        }
    }
}
