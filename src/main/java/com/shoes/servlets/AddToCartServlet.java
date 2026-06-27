package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.CartDAOImpl;
import com.shoes.model.Cart;
import com.shoes.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        // Check login
        if(session == null || session.getAttribute("user") == null){

            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        int shoeId =
                Integer.parseInt(request.getParameter("shoeId"));

        String size =
                request.getParameter("size");

        Cart cart = new Cart();

        cart.setUserId(user.getId());
        cart.setShoeId(shoeId);
        cart.setQuantity(1);
        cart.setSize(size);

        CartDAOImpl dao = new CartDAOImpl();

        boolean success = dao.addToCart(cart);

        if(success){

            response.sendRedirect("CartServlet");

        }else{

            response.sendRedirect("HomeServlet");
        }

    }
}