package com.DAO.Comment;

import com.DAO.Comment.CommentDAO;
import com.Model.Comment;
import com.Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentImpl implements CommentDAO {


    @Override
    public List<Comment> getCommentsForPost(int postID) {
        String sql = "SELECT * FROM comments WHERE postID = ? ORDER BY timestamp DESC";
        List<Comment> comments = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, postID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getInt("commentID"),
                        rs.getInt("postID"),
                        rs.getInt("userID"),
                        rs.getString("commentContent"),
                        rs.getTimestamp("timestamp")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public boolean addComment(Comment comment) {
        String sql = "INSERT INTO comments (postID, userID, commentContent) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, comment.getPostID());
            stmt.setInt(2, comment.getUserID());
            stmt.setString(3, comment.getCommentContent());
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Return false if the insert fails
    }
}
