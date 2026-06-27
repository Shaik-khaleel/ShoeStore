package com.shoes.servlets;

import java.io.IOException;

import com.shoes.DAOImpl.ShoeDAOImpl;
import com.shoes.model.Shoe;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateShoeServlet")
public class UpdateShoeServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Shoe shoe = new Shoe();

        shoe.setId(
        Integer.parseInt(
        request.getParameter("id")));

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

        dao.updateShoe(shoe);

        response.sendRedirect(
                "AdminDashboardServlet");
    }
}