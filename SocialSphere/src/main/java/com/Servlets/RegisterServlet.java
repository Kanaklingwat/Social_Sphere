package com.Servlets;

import com.DAO.User.UserDAO;
import com.DAO.User.UserImpl;
import com.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User newUser = new User(username, password, email);
        UserDAO userDAO = new UserImpl();
        boolean isUserRegistered = userDAO.registerUser(newUser);

        if (isUserRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("registrationError", "Registration failed! Username might already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}


