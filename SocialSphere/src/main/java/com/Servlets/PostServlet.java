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

@WebServlet("/createPost")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("createPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String postTitle = request.getParameter("postTitle");
        String postContent = request.getParameter("postContent");
        Post newPost = new Post(user.getUserID(), postTitle, postContent);
        PostDAO postDAO = new PostImpl();
        boolean isPostCreated = postDAO.createPost(newPost);

        if (isPostCreated) {
            response.sendRedirect("home");
        } else {
            request.setAttribute("errorMessage", "Failed to create the post. Try again.");
            request.getRequestDispatcher("createPost.jsp").forward(request, response);
        }
    }
}
