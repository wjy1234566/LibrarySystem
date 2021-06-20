package com.library.servlet;

import com.library.repository.ChangeKeyRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/key")
public class ChangeKeyServlet extends HttpServlet {

    /*
    * 修改密码业务逻辑
    * 描述：获得chang_key.jsp传递来的参数
    * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key1 = req.getParameter("key1");
        String key2 = req.getParameter("key2");
        String StuID = req.getParameter("StuID");
        if (!(key1.isEmpty() && key2.isEmpty())){
            if (key1.equals(key2)){
                ChangeKeyRepository changeKeyRepository = new ChangeKeyRepository();
                changeKeyRepository.changeKey(key1, StuID);
                // 两次密码相同则修改并返回
                req.setAttribute("message_suc", "修改成功！<br>");
                String password = req.getParameter("key1");
            }
            else{
                // 两次密码不同则返回
                req.setAttribute("message_err", "两次密码不同，请重新输入！<br>");
            }
        }
        else {
            // 存在空密码则返回
            req.setAttribute("message_null", "请输入密码！<br>");
        }
        req.getRequestDispatcher("change_key.jsp").forward(req, resp);
    }
}
