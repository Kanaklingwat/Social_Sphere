package com.Model;

import java.sql.Timestamp;
import java.util.List;

public class Post {
    private int postID;
    private int userID;
    private String postTitle;
    private String postContent;
    private Timestamp timestamp;
    private List<Comment> comments;  // List of comments for this post


    public Post(int userID, String postTitle, String postContent) {
        this.userID = userID;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }


    public Post(int postID, int userID, String postTitle, String postContent, Timestamp timestamp) {
        this.postID = postID;
        this.userID = userID;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.timestamp = timestamp;
    }


    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;  // Set the comments for this post
    }
}
