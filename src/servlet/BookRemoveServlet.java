package com.library.servlet;

import com.library.repository.BookRemoveRepository;
import com.library.repository.ReaderRemoveRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book_remove")
public class BookRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BookID = req.getParameter("BookID");
        BookRemoveRepository bookRemoveRepository = new BookRemoveRepository();
        boolean check = bookRemoveRepository.removeBook(BookID);

        if (check){
            req.setAttribute("book_remove_success","删除图书成功!<br>");
        }
        else {
            req.setAttribute("book_remove_err","删除图书失败!<br>");
        }
        req.getRequestDispatcher("book_remove.jsp").forward(req,resp);
    }
}
