package com.DAO.Post;

import com.DAO.Post.PostDAO;
import com.Model.Post;
import com.Util.DBUtil;

import java.sql.*;
import java.util.*;

public class PostImpl implements PostDAO {

    @Override
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts ORDER BY timestamp DESC";
        List<Post> posts = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                posts.add(new Post(
                        rs.getInt("postID"),
                        rs.getInt("userID"),
                        rs.getString("postTitle"),
                        rs.getString("postContent"),
                        rs.getTimestamp("timestamp")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public List<Post> getPostsByUserID(int userID) {
        String sql = "SELECT * FROM posts WHERE userID = ? ORDER BY timestamp DESC";
        List<Post> posts = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Post post = new Post(
                        rs.getInt("postID"),
                        rs.getInt("userID"),
                        rs.getString("postTitle"),
                        rs.getString("postContent"),
                        rs.getTimestamp("timestamp")
                );
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public boolean createPost(Post post) {
        String sql = "INSERT INTO posts (userID, postTitle, postContent) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, post.getUserID());
            stmt.setString(2, post.getPostTitle());
            stmt.setString(3, post.getPostContent());
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
