package com.adoptaamor.adoptaamor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {

    private static final Dotenv dotenv = Dotenv.configure().directory(".gitignore").load();

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/adopta-amor";
    private static final String USERNAME = dotenv.get("USER");
    private static final String PASSWORD = dotenv.get("PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}