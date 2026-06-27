package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EditShoeServlet")
public class EditShoeServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException,
            jakarta.servlet.ServletException {

        int id =
        Integer.parseInt(
        request.getParameter("id"));

        ShoeDAOImpl dao =
                new ShoeDAOImpl();

        Shoe shoe =
                dao.getShoeById(id);

        request.setAttribute(
                "shoe",
                shoe);

        request.getRequestDispatcher(
               "editShoe.jsp")
                .forward(request,response);
        
    }
}