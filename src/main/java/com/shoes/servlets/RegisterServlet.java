package com.shoes.servlets;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.shoes.DAOImpl.UserDAOImpl;
import com.shoes.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        // Encrypt Password
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashPassword);
        user.setMobile(mobile);
        user.setAddress(address);

        UserDAOImpl dao = new UserDAOImpl();

        boolean status = dao.registerUser(user);

        if (status) {

            System.out.println("Registration Successful");

            response.sendRedirect("login.jsp");

        } else {

            System.out.println("Registration Failed");

            response.sendRedirect("register.jsp");
        }
    }
}