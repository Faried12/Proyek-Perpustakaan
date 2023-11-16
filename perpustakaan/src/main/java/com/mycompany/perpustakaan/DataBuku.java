/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DataBuku {
    static void tambah(String nama, String kategori, String penulis, String stock) throws IOException{
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "INSERT INTO data_buku (id_buku, nama, kategori, penulis, stock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            String id = null;
            
            if (kategori == "Komik"){
                id = "B1" + generate.numId(5);
            }else if (kategori == "Novel"){
                id = "B2" + generate.numId(10);
            }else if (kategori == "Jurnal"){
                id = "B3" + generate.numId(5);
            }else{
                id = "B4" + generate.numId(30);
            }
            
            statement.setString(1, id);
            statement.setString(2, nama);
            statement.setString(3, kategori);
            statement.setString(4, penulis);
            statement.setString(5, stock);
            
            statement.executeUpdate();
            statement.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void hapus(String id){
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "DELETE FROM data_buku WHERE id_buku = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, id);
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    static void update(String id, String nama, String kategori, String penulis, String stock){
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "UPDATE data_buku SET nama = ?, kategori = ?,penulis = ?,stock= ? WHERE id_buku = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(5, id);
            statement.setString(1, nama);
            statement.setString(2, kategori);
            statement.setString(3, penulis);
            statement.setString(4, stock);

            statement.executeUpdate();
            statement.close();
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
}
