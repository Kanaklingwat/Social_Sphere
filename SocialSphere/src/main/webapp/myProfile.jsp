<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>My Profile - SocialSphere</title>
</head>
<body>
    <h2>${user.username}'s Profile</h2>
    <p>Email: ${user.email}</p>

    <h3>Your Posts:</h3>
    <c:if test="${not empty posts}">
        <ul>
            <c:forEach var="post" items="${posts}">
                <li>
                    <h4>${post.postTitle}</h4>
                    <p>${post.postContent}</p>
                    <p><em>Posted on: ${post.timestamp}</em></p>
                    <a href="viewPost.jsp?postID=${post.postID}">View Details</a>
                </li>
                <hr>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty posts}">
        <p>You have not posted anything yet.</p>
    </c:if>

    <a href="home.jsp"><button>Back to Home</button></a>
</body>
</html>
