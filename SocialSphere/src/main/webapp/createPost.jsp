<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Create Post - SocialSphere</title>
</head>
<body>
    <h2>Create a New Post</h2>

    <!-- Display error message if post creation fails -->
    <c:if test="${not empty errorMessage}">
        <h3 style="color:red">${errorMessage}</h3>
    </c:if>

    <!-- Post Creation Form -->
    <form action="createPost" method="post">
        <div>
            <label for="postTitle">Title:</label>
            <input type="text" name="postTitle" required /><br><br>
        </div>

        <div>
            <label for="postContent">Content:</label>
            <textarea name="postContent" required></textarea><br><br>
        </div>

        <div>
            <input type="submit" value="Create Post" />
        </div>
    </form>

    <a href="home.jsp"><button>Back to Home</button></a>
</body>
</html>
