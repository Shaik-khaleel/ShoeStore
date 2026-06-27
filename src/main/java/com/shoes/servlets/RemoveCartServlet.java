package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.CartDAOImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int cartId =
        Integer.parseInt(
        request.getParameter("id"));

        CartDAOImpl dao =
                new CartDAOImpl();

        dao.removeCartItem(cartId);

        response.sendRedirect(
                "CartServlet");
    }
}