/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class PeminjamanBuku {
    static void tambah(String anggota, String buku) throws IOException{
        try{
            LocalDate date = LocalDate.now();
            String tanggal = date.toString();
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String pquery = "INSERT INTO peminjaman (id_peminjaman, tanggal_peminjaman, pengembalian, id_anggota, id_buku) VALUES (?, ?, 0, ?,?)";
            PreparedStatement statement = connection.prepareStatement(pquery);
            
            String num = generate.numId(20);
            String tgl = generate.date(tanggal);
            String id_peminjaman = "M" + tgl + num ;

            statement.setString(1, id_peminjaman);
            statement.setString(2, tanggal);
            statement.setString(3, anggota);
            statement.setString(4, buku); 
            
            statement.executeUpdate();
            statement.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
