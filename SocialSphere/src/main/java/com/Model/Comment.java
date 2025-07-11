package com.Model;

import java.sql.Timestamp;

public class Comment {
    private int commentID;
    private int postID;
    private int userID;
    private String commentContent;
    private Timestamp timestamp;


    public Comment(int postID, int userID, String commentContent) {
        this.postID = postID;
        this.userID = userID;
        this.commentContent = commentContent;
    }


    public Comment(int commentID, int postID, int userID, String commentContent, Timestamp timestamp) {
        this.commentID = commentID;
        this.postID = postID;
        this.userID = userID;
        this.commentContent = commentContent;
        this.timestamp = timestamp;
    }

    
    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

