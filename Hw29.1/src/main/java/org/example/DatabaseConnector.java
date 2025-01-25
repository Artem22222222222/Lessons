package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String name = System.getenv("name");
    private final String password = System.getenv("password");
    private final String DB_name = System.getenv("DB_name");
    private final String URL = "jdbc:mysql://localhost:3306/" + DB_name;

    public DatabaseConnector() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, name, password);
    }

}
