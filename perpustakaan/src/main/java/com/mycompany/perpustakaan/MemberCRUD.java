/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;

/**
 *
 * @author bangu
 */
public class MemberCRUD {
    public Static create(){
        String sql = “SELECT kode, nama, alamat, kelas FROM dataSiswa”;
        ResultSet set = stat.executeQuery(sql);
        while (set.next()) {
        String kode = set.getString(“kode”);
        String nama = set.getString(“nama”);
        String alamat = set.getString(“alamat”);
        String kelas = set.getString(“kelas”);
        }
    }
}
