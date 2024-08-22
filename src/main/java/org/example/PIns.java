package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PIns {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "indian123";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to PostgreSQL database established successfully!");


            String query = "INSERT INTO products (product_id, product_name, price, category_id, stock_quantity) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, 1); // Sample product ID
            preparedStatement.setString(2, "Sample Product"); // Sample product name
            preparedStatement.setDouble(3, 99.99);
            preparedStatement.setInt(2, 2);
            preparedStatement.setInt(4, 10); // Sample quantity


            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new product was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Failed to insert data into PostgreSQL database.");
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
