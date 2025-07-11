package com.Servlets;

import com.DAO.Post.PostDAO;
import com.DAO.Post.PostImpl;
import com.Model.Post;
import com.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/myProfile")
public class MyProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");


        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        PostDAO postDAO = new PostImpl();
        List<Post> posts = postDAO.getPostsByUserID(user.getUserID());

        request.setAttribute("user", user);
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("myProfile.jsp").forward(request, response);
    }
}
