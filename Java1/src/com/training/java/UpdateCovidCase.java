package com.training.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCovidCase {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3305/userprofile";
        String username = "root";
        String password = "Rahul@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE CovidCases1 SET recoveryDate = ?, severity = ? WHERE caseID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf("2023-02-21"));
            statement.setString(2, "Mild");
            statement.setInt(3, 1); 

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Covid case details have been updated successfully.");
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}