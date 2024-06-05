package com.training.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration {
    public static void main(String args[]) {
      final String url = "jdbc:mysql://localhost:3305/userprofile";
      final String username = "root";
      final String password = "Rahul@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

          final String sql = "INSERT INTO Userdetails (firstName, lastName, age, gender, contactInfo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "ashok");
            statement.setString(2, "k");
            statement.setInt(3, 23);
            statement.setString(4, "Male");
            statement.setString(5, "shok@example.com");

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("A new user has been inserted successfully.");
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}