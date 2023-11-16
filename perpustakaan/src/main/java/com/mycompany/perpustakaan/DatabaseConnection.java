/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author HP
 */
public class DatabaseConnection {
    // Private static instance of the DatabaseConnection class
    private static DatabaseConnection instance;

    // Private constructor to prevent instantiation from other classes
    private DatabaseConnection() {
    }

    // Public method to get the single instance of DatabaseConnection
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Public method to get a database connection
    public Connection getConnection() throws SQLException {
        // Here, you can configure your database connection parameters
        String url = "jdbc:mysql://localhost:3306/perpustakaan";
        String username = "root";
        String password = "";

        return DriverManager.getConnection(url, username, password);
    }
}

