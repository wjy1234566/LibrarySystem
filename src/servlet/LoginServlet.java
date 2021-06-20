package com.library.servlet;

import com.library.repository.LoginRepository;
import com.sun.deploy.util.SessionState;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// LoginServlet 和 “/login” 映射
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /*
    * 登录功能的业务逻辑
    * 描述：获得login.jsp传递来的ID和password，并在数据库检索
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String StuID = req.getParameter("ID");
        String password = req.getParameter("password");
        LoginRepository loginRepository = new LoginRepository();
        boolean check = loginRepository.checkLogin(StuID,password);
        if (check) {
            // 登录成功则把StuID传递给index.jsp页面
            req.setAttribute("StuID",StuID);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else {
            // 登录失败则返回登陆页面
            req.setAttribute("message", "账号或密码错误，请重新登录<br>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
