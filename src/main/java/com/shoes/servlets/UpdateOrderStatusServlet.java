package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.OrderDAOImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateOrderStatusServlet")
public class UpdateOrderStatusServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int orderId =
        Integer.parseInt(
        request.getParameter("orderId"));

        String status =
        request.getParameter("status");

        OrderDAOImpl dao =
                new OrderDAOImpl();

        dao.updateOrderStatus(
                orderId,
                status);

        response.sendRedirect(
                "AdminOrdersServlet");
    }
}