package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException,
            jakarta.servlet.ServletException {

        String keyword =
        request.getParameter("keyword");

        ShoeDAOImpl dao =
                new ShoeDAOImpl();

        List<Shoe> list =
        dao.searchShoes(keyword);

        request.setAttribute(
                "shoeList",
                list);

        request.getRequestDispatcher(
                "home.jsp")
                .forward(request,response);
    }
}