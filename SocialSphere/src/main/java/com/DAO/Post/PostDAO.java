package com.DAO.Post;

import com.Model.Post;
import java.util.List;

public interface PostDAO {
    boolean createPost(Post post);
    List<Post> getPostsByUserID(int userID);
    List<Post> getAllPosts();
}
