package com.DAO.Comment;
import com.Model.Comment;
import java.util.List;

public interface CommentDAO {
    boolean addComment(Comment comment);

    List<Comment> getCommentsForPost(int postID);
}