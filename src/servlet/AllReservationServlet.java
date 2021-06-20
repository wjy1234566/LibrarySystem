package com.library.servlet;

import com.library.entity.ReservationEntity;
import com.library.repository.AllReservationRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all_reservation")
public class AllReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AllReservationRepository allReservationRepository = new AllReservationRepository();
        List<ReservationEntity> list = allReservationRepository.returnReservation();
        if (! list.isEmpty()){
            req.setAttribute("list",list);
        }
        else {
            req.setAttribute("message", "无预约记录<br>");
        }
        req.getRequestDispatcher("view_all_reservation.jsp").forward(req,resp);
    }


}
