package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.ShoeDAOImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/DeleteShoeServlet")
public class DeleteShoeServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id =
        Integer.parseInt(
        request.getParameter("id"));

        ShoeDAOImpl dao =
                new ShoeDAOImpl();

        dao.deleteShoe(id);

        response.sendRedirect(
                "AdminDashboardServlet");
    }
}