package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.OrderDAOImpl;
import com.shoes.model.Order;
import com.shoes.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute("user");

        if(user == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        OrderDAOImpl dao =
                new OrderDAOImpl();
        System.out.println("Logged User ID = " + user.getId());

        List<Order> orders = dao.getOrdersByUserId(user.getId());

        System.out.println("Orders Found = " + orders.size());

        request.setAttribute("orders", orders);

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("myOrders.jsp")
               .forward(request, response);
    }
}