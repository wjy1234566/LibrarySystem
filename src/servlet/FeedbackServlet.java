package com.library.servlet;

import com.library.repository.FeedbackRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("feedback");
        FeedbackRepository feedbackRepository = new FeedbackRepository();
        feedbackRepository.newFeedback(comment);
        req.setAttribute("success", "感谢您的反馈！<br>");
        req.getRequestDispatcher("feedback.jsp").forward(req, resp);
    }
}
