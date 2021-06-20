package com.library.servlet;

import com.library.entity.HistoryBookEntity;
import com.library.entity.NowBookEntity;
import com.library.repository.ViewBorrowBookRepository;
import javafx.scene.layout.HBox;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view_borrow_book")
public class ViewBorrowBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得当前session中的读者号
        String StuID = (String) req.getSession().getAttribute("StuID");
        ViewBorrowBookRepository viewBorrowBookRepository = new ViewBorrowBookRepository();
        List<NowBookEntity> nowBookEntityList = viewBorrowBookRepository.returnNowBook(StuID);
        List<HistoryBookEntity> historyBookEntityList = viewBorrowBookRepository.returnHistoryBook(StuID);
        // 将结果返回给view_borrow_book.jsp
        req.setAttribute("now_borrow_book",nowBookEntityList);
        req.setAttribute("his_borrow_book",historyBookEntityList);
        req.getRequestDispatcher("view_borrow_book.jsp").forward(req,resp);
    }
}
