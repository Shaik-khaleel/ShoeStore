package com.shoes.controller;

import java.io.IOException;

import com.shoes.DAOImpl.CartDAOImpl;
import com.shoes.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ClearCartServlet")
public class ClearCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute("user");

        if(user != null) {

            CartDAOImpl dao =
                    new CartDAOImpl();

            dao.clearCart(user.getId());
        }

        response.sendRedirect("CartServlet");
    }
}