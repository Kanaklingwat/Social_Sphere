package com.Servlets;

import com.DAO.Post.PostDAO;
import com.DAO.Post.PostImpl;
import com.DAO.Comment.CommentDAO;
import com.DAO.Comment.CommentImpl;
import com.Model.Post;
import com.Model.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewPosts")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PostDAO postDAO = new PostImpl();
        List<Post> posts = postDAO.getAllPosts();
        CommentDAO commentDAO = new CommentImpl();
        for (Post post : posts) {
            List<Comment> comments = commentDAO.getCommentsForPost(post.getPostID());
            post.setComments(comments);
        }

        request.setAttribute("posts", posts);
        request.getRequestDispatcher("viewPosts.jsp").forward(request, response);
    }
}
