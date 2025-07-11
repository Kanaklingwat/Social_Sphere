<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register - SocialSphere</title>
</head>
<body>
    <h2>Sign Up</h2>

    <!-- Display error message if registration fails -->
    <c:if test="${not empty registrationError}">
        <h3 style="color:red">${registrationError}</h3>
    </c:if>

    <!-- Registration Form -->
    <form action="register" method="post">
        <div>
            <label for="username">Username:</label>
            <input type="text" name="username" required /><br><br>
        </div>

        <div>
            <label for="password">Password:</label>
            <input type="password" name="password" required /><br><br>
        </div>

        <div>
            <label for="email">Email:</label>
            <input type="email" name="email" required /><br><br>
        </div>

        <div>
            <input type="submit" value="Register" />
        </div>
    </form>

    <!-- Link to Login Page -->
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
