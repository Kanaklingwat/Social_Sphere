<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>View Posts - SocialSphere</title>
</head>
<body>
    <h2>Posts from Other Users</h2>

    <c:if test="${not empty posts}">
        <ul>
            <c:forEach var="post" items="${posts}">
                <li>
                    <h3>${post.postTitle}</h3>
                    <p>${post.postContent}</p>
                    <p><em>Posted on: ${post.timestamp}</em></p>

                    <!-- Display Comments -->
                    <h4>Comments:</h4>
                    <c:if test="${not empty post.comments}">
                        <ul>
                            <c:forEach var="comment" items="${post.comments}">
                                <li>
                                    <strong>User ${comment.userID}</strong>: ${comment.commentContent}
                                    <p><em>Commented on: ${comment.timestamp}</em></p>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                    <c:if test="${empty post.comments}">
                        <p>No comments yet.</p>
                    </c:if>

                    <!-- Add Comment Form -->
                    <h4>Add a Comment:</h4>
                    <form action="addComment" method="post">
                        <input type="hidden" name="postID" value="${post.postID}" />
                        <textarea name="commentContent" required></textarea><br><br>
                        <input type="submit" value="Add Comment" />
                    </form>
                    <hr>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty posts}">
        <p>No posts found.</p>
    </c:if>

    <a href="home.jsp"><button>Back to Home</button></a>
</body>
</html>
