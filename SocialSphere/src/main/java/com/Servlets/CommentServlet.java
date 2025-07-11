package com.Servlets;

import com.DAO.Comment.CommentDAO;
import com.DAO.Comment.CommentImpl;
import com.Model.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addComment")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int postID = Integer.parseInt(request.getParameter("postID"));
        String commentContent = request.getParameter("commentContent");
        Comment comment = new Comment(postID, userID, commentContent);
        CommentDAO commentDAO = new CommentImpl();
        boolean isCommentAdded = commentDAO.addComment(comment);

        if (isCommentAdded) {

            response.sendRedirect("viewPost.jsp?postID=" + postID);
        } else {

            request.setAttribute("errorMessage", "Failed to add comment. Try again.");
            request.getRequestDispatcher("viewPost.jsp?postID=" + postID).forward(request, response);
        }
    }
}

