package com.Util;

import java.sql.*;

public class DBUtil {
    private static final String JDBC_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASS);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            String createUserTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "userID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(100) NOT NULL)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createUserTable);
            }

            String createPostTable = "CREATE TABLE IF NOT EXISTS posts (" +
                    "postID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "userID INT, " +
                    "postTitle VARCHAR(100) NOT NULL, " +
                    "postContent TEXT NOT NULL, " +
                    "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    "FOREIGN KEY (userID) REFERENCES users(userID))";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createPostTable);
            }

            System.out.println("Database tables created (if they did not exist).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
