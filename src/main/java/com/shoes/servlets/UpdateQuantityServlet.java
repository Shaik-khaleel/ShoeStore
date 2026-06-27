package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.CartDAOImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateQuantityServlet")
public class UpdateQuantityServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        int cartId =
        Integer.parseInt(
        request.getParameter("cartId"));

        int quantity =
        Integer.parseInt(
        request.getParameter("quantity"));

        if(quantity < 1){
            quantity = 1;
        }

        CartDAOImpl dao =
                new CartDAOImpl();

        dao.updateQuantity(cartId, quantity);

        response.sendRedirect("CartServlet");
    }
}