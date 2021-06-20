package com.library.servlet;

import com.library.repository.BorrowBookRepository;
import com.library.repository.ChangeKeyRepository;
import com.library.repository.ReturnBookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/return_book")
public class ReturnBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BookID = req.getParameter("return_BookID");
        String StuID = req.getParameter("return_StuID");
        ReturnBookRepository returnBookRepository = new ReturnBookRepository();
        boolean check = returnBookRepository.addBorrow(StuID,BookID);

        if (check){
            // 返回还书成功
            req.setAttribute("return_success", "还书成功！<br>");
        }
        else {
            // 返回还书失败
            req.setAttribute("return_err", "未找到借阅记录，还书失败！<br>");
        }
        req.getRequestDispatcher("return_book.jsp").forward(req, resp);
    }
}
