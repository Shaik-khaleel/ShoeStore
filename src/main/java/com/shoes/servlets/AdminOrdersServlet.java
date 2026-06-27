package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.OrderDAOImpl;
import com.shoes.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminOrdersServlet")
public class AdminOrdersServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        OrderDAOImpl dao =
                new OrderDAOImpl();

        List<Order> orders =
                dao.getAllOrders();

        request.setAttribute(
                "orders",
                orders);

        request.getRequestDispatcher(
                "adminOrders.jsp")
                .forward(request,response);
    }
}