<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login - SocialSphere</title>
</head>
<body>
    <h2>Sign In</h2>

    <!-- Display error message if login fails -->
    <!-- Login Form -->
    <form action="login" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" name="username" required /><br><br>
        </div>

        <div>
            <label for="password">Password:</label>
            <input type="password" name="password" required /><br><br>
        </div>

        <div>
            <button type="submit"> Submit</button>
        </div>
    </form>

    <!-- Link to Registration Page -->
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>
