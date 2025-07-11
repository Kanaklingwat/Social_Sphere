<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome to SocialSphere</title>
</head>
<body>
    <!-- Welcome message -->
    <h2>Welcome, ${user.username}!</h2>

    <!-- Buttons for View Other Users' Posts, My Profile, Create Post, and Logout -->
    <a href="viewPosts.jsp"><button>View Other Users' Posts</button></a><br><br>
    <a href="myProfile.jsp"><button>My Profile</button></a><br><br>
    <a href="createPost.jsp"><button>Create Post</button></a><br><br>
    <a href="logout.jsp"><button>Logout</button></a><br><br>

    <hr>

    <!-- Display user posts -->
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

</body>
</html>
