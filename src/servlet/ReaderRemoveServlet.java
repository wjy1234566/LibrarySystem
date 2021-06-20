package com.library.servlet;

import com.library.repository.ReaderRegisterRepository;
import com.library.repository.ReaderRemoveRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader_remove")
public class ReaderRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StuID = req.getParameter("StuID");
        ReaderRemoveRepository readerRemoveRepository = new ReaderRemoveRepository();
        boolean check = readerRemoveRepository.removeReader(StuID);

        if (check){
            req.setAttribute("remove_success","注销用户成功!<br>");
        }
        else {
            req.setAttribute("remove_err","注销失败!<br>");
        }
        req.getRequestDispatcher("reader_remove.jsp").forward(req,resp);
    }
}
