package com.library.servlet;

import com.library.repository.LoginAdminRepository;
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
@WebServlet("/login_admin")
public class LoginAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AdminID = req.getParameter("ID");
        String password = req.getParameter("password");
        LoginAdminRepository loginAdminRepository = new LoginAdminRepository();
        boolean check = loginAdminRepository.checkLogin(AdminID,password);
        if (check) {
            // 登录成功则把StuID传递给index.jsp页面
            req.setAttribute("AdminID",AdminID);
            req.getRequestDispatcher("index_admin.jsp").forward(req,resp);
        }else {
            // 登录失败则返回登陆页面
            req.setAttribute("message", "账号或密码错误，请重新登录<br>");
            req.getRequestDispatcher("login_admin.jsp").forward(req, resp);
        }
    }
}
