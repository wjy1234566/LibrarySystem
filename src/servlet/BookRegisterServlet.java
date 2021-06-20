package com.library.servlet;

import com.library.repository.BookRegisterRepository;
import com.library.repository.ReaderRegisterRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book_register")
public class BookRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BookID = req.getParameter("BookID");
        String BookName = req.getParameter("BookName");
        String Author = req.getParameter("Author");
        String Price = req.getParameter("Price");
        String Publisher = req.getParameter("Publisher");
        Integer Quantity =Integer.parseInt(req.getParameter("Quantity"));
        String BookClass = req.getParameter("BookClass");
        String BookSurface = req.getParameter("BookSurface");

        BookRegisterRepository bookRegisterRepository = new BookRegisterRepository();
        boolean check = bookRegisterRepository.addBook(BookID,BookName,Author,Price,Publisher,Quantity,BookClass,BookSurface);

        if (check){
            req.setAttribute("book_register_success","注册成功!<br>");
        }
        else {
            req.setAttribute("book_register_err","注册失败!<br>");
        }
        req.getRequestDispatcher("book_register.jsp").forward(req,resp);
    }
}
