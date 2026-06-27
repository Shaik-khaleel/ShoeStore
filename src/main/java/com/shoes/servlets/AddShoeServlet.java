package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddShoeServlet")
public class AddShoeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Shoe shoe = new Shoe();

        shoe.setShoeName(
        request.getParameter("shoeName"));

        shoe.setBrand(
        request.getParameter("brand"));

        shoe.setCategory(
        request.getParameter("category"));

        shoe.setDescription(
        request.getParameter("description"));

        shoe.setPrice(
        Double.parseDouble(
        request.getParameter("price")));

        shoe.setSizes(
        request.getParameter("sizes"));

        shoe.setImage(
        request.getParameter("image"));

        shoe.setStock(
        Integer.parseInt(
        request.getParameter("stock")));

        shoe.setStatus(
        request.getParameter("status"));

        ShoeDAOImpl dao =
                new ShoeDAOImpl();

        dao.addShoe(shoe);

        response.sendRedirect(
                "AdminDashboardServlet");
    }
}