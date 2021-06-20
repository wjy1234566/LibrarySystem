package com.library.servlet;

import com.library.entity.HistoryBookEntity;
import com.library.entity.NowBookEntity;
import com.library.entity.ViewReservationEntity;
import com.library.repository.ViewBorrowBookRepository;
import com.library.repository.ViewReservationBookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view_reservation_book")
public class ViewReservationBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得当前session中的读者号
        String StuID = (String) req.getSession().getAttribute("StuID");
        ViewReservationBookRepository viewReservationBookRepository =new ViewReservationBookRepository();
        List<ViewReservationEntity> list = viewReservationBookRepository.returnReservationBook(StuID);

        req.setAttribute("list",list);
        req.getRequestDispatcher("view_reservation_book.jsp").forward(req,resp);
    }
}
