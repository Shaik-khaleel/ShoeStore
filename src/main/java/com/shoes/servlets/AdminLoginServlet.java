package com.shoes.servlets;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        if(email.equals("admin@gmail.com")
                && password.equals("admin123")) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "admin",
                    email);

            response.sendRedirect(
                    "AdminDashboardServlet");

        } else {

            response.sendRedirect(
                    "adminLogin.jsp");
        }
    }
}