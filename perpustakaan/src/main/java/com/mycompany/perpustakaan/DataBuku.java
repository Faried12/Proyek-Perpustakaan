/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DataBuku {
    static void create(){
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "INSERT INTO anggota (nama, nim, prodi) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            System.out.print("Masukan nama: ");
            String nama = scan.next();
            statement.setString(1, nama);

            System.out.print("Masukan NIM: ");
            String nim = scan.next();
            statement.setString(2, nim);

            System.out.print("Masukan prodi: ");
            String prodi = scan.next();
            statement.setString(3, prodi);

            statement.executeUpdate();
            statement.close();
            System.out.println("Data berhasil dibuat");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
