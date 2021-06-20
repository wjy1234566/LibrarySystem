package com.library.servlet;

import com.library.entity.TakeBookEntity;
import com.library.repository.TakeBookManagementRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/take_book_management")
public class TakeBookManagementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StuID = req.getParameter("StuID");
        TakeBookManagementRepository takeBookManagementRepository = new TakeBookManagementRepository();
        List<TakeBookEntity> list = takeBookManagementRepository.returnTakeBook(StuID);
        if (! list.isEmpty()){
            req.setAttribute("list",list);
        }
        else {
            req.setAttribute("message", "此读者无预约记录！<br>");
        }
        req.getRequestDispatcher("take_book_management.jsp").forward(req,resp);
    }
}
