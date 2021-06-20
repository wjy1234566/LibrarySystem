package com.library.servlet;

import com.library.repository.ReaderRegisterRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader_register")
public class ReaderRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StuID = req.getParameter("StuID");
        String StuName = req.getParameter("StuName");
        String Sex = req.getParameter("Sex");
        String Dept = req.getParameter("Dept");
        String Major = req.getParameter("Major");

        ReaderRegisterRepository readerRegisterRepository = new ReaderRegisterRepository();
        boolean check = readerRegisterRepository.addReader(StuID,StuName,Sex,Dept,Major);

        if (check){
            req.setAttribute("register_success","注册成功!<br>");
        }
        else {
            req.setAttribute("register_err","注册失败!<br>");
        }
        req.getRequestDispatcher("reader_register.jsp").forward(req,resp);
    }
}
