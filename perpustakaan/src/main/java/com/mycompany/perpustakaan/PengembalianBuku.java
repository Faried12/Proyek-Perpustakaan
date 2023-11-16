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
public class PengembalianBuku {
    static void tambah(String id) throws IOException{
        try{
            LocalDate date = LocalDate.now();
            String tanggal = date.toString();
            String dbid = "";
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM data_buku WHERE id_buku = '"+id+"';";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                dbid = rs.getString("id_buku");
            }
            if (id == dbid){
                String pquery = "INSERT INTO pengembalian (id_pengembalian, tanggal_pengembalian, denda, id_peminjaman) VALUES (?, ?, ?, ?)";
                PreparedStatement pstatement = connection.prepareStatement(pquery);
                
                String num = generate.numId(25);
                String tgl = generate.date(tanggal);
                String id_pengembalian = "K" + tgl + num ;
                
                String denda = generate.denda(tanggal);
                
                pstatement.setString(1, id_pengembalian);
                pstatement.setString(2, tanggal);
                pstatement.setString(3, denda);
                pstatement.setString(4, id);  
            }      
            statement.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
