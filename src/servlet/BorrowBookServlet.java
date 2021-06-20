package com.library.servlet;

import com.library.repository.BorrowBookRepository;
import com.library.repository.ChangeKeyRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/borrow_book")
public class BorrowBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BookID = req.getParameter("BookID");
        String StuID = req.getParameter("StuID");
        BorrowBookRepository borrowBookRepository = new BorrowBookRepository();
        boolean check = borrowBookRepository.addBorrow(StuID,BookID,"0");

        if (check){
            // 返回借阅成功
            req.setAttribute("borrow_success", "借阅成功！<br>");
        }
        else {
            // 返回借阅成功
            req.setAttribute("borrow_err", "借阅失败！图书馆不存在此书！<br>");
        }
        req.getRequestDispatcher("borrow_book.jsp").forward(req, resp);
    }
}
