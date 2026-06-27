package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        ShoeDAOImpl dao = new ShoeDAOImpl();

        List<Shoe> list = dao.getAllShoes();

        request.setAttribute("shoeList", list);

        request.getRequestDispatcher("adminDashboard.jsp")
               .forward(request, response);
    }
}