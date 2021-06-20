package com.library.servlet;

import com.library.entity.FeedbackEntity;
import com.library.repository.GetFeedbackRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/get_feedback")
public class GetFeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetFeedbackRepository getFeedbackRepository = new GetFeedbackRepository();
        List<FeedbackEntity> list = getFeedbackRepository.getFeedback();
        req.setAttribute("list",list);
        req.getRequestDispatcher("get_feedback.jsp").forward(req,resp);
    }
}
