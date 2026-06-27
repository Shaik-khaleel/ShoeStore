package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.CartDAOImpl;
import com.shoes.model.Cart;
import com.shoes.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user =
        (User) session.getAttribute("user");

        if(user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        CartDAOImpl dao =
                new CartDAOImpl();

        List<Cart> cartList =
                dao.getCartItems(user.getId());

        request.setAttribute(
                "cartList",
                cartList);

        request.getRequestDispatcher(
                "cart.jsp")
                .forward(request, response);
    }
}