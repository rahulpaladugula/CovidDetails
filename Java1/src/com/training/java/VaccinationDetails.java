package com.training.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VaccinationDetails {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3305/userprofile";
        String username = "root";
        String password = "Rahul@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO Vaccination (userID, vaccineName, doseDate, doseNumber) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 3); 
            statement.setString(2, "Moderna");
            statement.setDate(3, java.sql.Date.valueOf("2023-02-02"));
            statement.setInt(4, 3);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Vaccination details have been inserted successfully.");
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}