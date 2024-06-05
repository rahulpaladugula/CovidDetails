package com.training.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageCovidHistory {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3305/userprofile";
        String username = "root";
        String password = "Rahul@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO CovidCases1 (userID, diagnosisDate, recoveryDate, severity) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 3); 
            statement.setDate(2, java.sql.Date.valueOf("2023-03-02"));
            statement.setDate(3, java.sql.Date.valueOf("2023-03-30"));
            statement.setString(4, "High");

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Covid history has been inserted successfully.");
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}