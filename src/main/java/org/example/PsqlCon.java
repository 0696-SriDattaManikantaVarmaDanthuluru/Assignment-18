package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PsqlCon {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "indian123";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to PostgreSQL database established successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to PostgreSQL database.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

