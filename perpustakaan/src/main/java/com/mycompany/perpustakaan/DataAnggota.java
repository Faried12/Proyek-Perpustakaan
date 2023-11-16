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
public class DataAnggota {
static void tambah( String nama, String jenis_kelamin, String tanggal_lahir, String alamat, String no_telpon) throws IOException{
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "INSERT INTO data_anggota (id_anggota, nama, jenis_kelamin, tanggal_lahir, alamat, no_telpon) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            String id_anggota = "A" + generate.numId(0);
                    
            statement.setString(1, id_anggota);
            statement.setString(2, nama);
            statement.setString(3, jenis_kelamin);
            statement.setString(4, tanggal_lahir);
            statement.setString(5, alamat);
            statement.setString(6, no_telpon);
            
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
            String query = "DELETE FROM data_anggota WHERE id_anggota = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, id);
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    static void update(String id_anggota, String nama, String jenis_kelamin, String tanggal_lahir, String alamat, String no_telpon){
        try{
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            String query = "UPDATE data_anggota SET nama = ?, jenis_kelamin = ?,tanggal_lahir = ?,alamat= ?,no_telpon=? WHERE id_anggota = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(6, id_anggota);
            statement.setString(1, nama);
            statement.setString(2, jenis_kelamin);
            statement.setString(3, tanggal_lahir);
            statement.setString(4, alamat);
            statement.setString(5, no_telpon);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }    
}
