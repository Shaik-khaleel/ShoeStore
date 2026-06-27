package com.shoes.servlets;

import java.io.IOException;
import java.util.List;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String category = request.getParameter("category");

        ShoeDAOImpl dao = new ShoeDAOImpl();

    
    List<Shoe> shoeList;

    if(category == null || category.isEmpty()) {

        shoeList = dao.getAllShoes();

    } else {

        shoeList = dao.getShoesByCategory(category);
    }

    System.out.println("Shoes Found = " + shoeList.size());

    request.setAttribute("shoeList", shoeList);

    request.getRequestDispatcher("home.jsp")
           .forward(request, response);
}
}