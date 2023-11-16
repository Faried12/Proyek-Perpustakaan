/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpustakaan;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author HP
 */
public class generate {
    static String  numId(int skp) throws IOException{
        FileReader fileReader = null;
        String substring = "";
                
        File fid = new File("idList.txt");
        fileReader = new FileReader(fid);
        fileReader.skip(skp);

        char[] buffer = new char[4];
        int bytesRead = fileReader.read(buffer);
        if (bytesRead != -1) {
            substring = new String(buffer);
            int number = Integer.parseInt(substring); 
            number = number+1;
            String nmbr = "";
            String newstring = "";
            if (number > 1000){
                nmbr = String.valueOf(number);
                newstring = nmbr;
            }else if (number > 100){
                nmbr = String.valueOf(number);
                newstring = "0" + nmbr;
            }else if (number > 10){
                nmbr = String.valueOf(number);
                substring = "00" + nmbr;
            }else{
                nmbr = String.valueOf(number);
                newstring = "000" + nmbr;
            }
            RandomAccessFile file = new RandomAccessFile(fid, "rw");
            file.seek(skp);
            String replacement = newstring; 
            file.writeBytes(replacement);
        }
        return substring;   
    }
    static String date(String date){
        date = date.substring(2);
        date = date.substring(0, 5);
        date = date.substring(0,2) + date.substring(3);
        return date;
    }
    
    static String denda(String date){
        LocalDate currentDate = LocalDate.now();
        LocalDate anotherDate = LocalDate.of(2022, 1, 1);
        long daysDifference = ChronoUnit.DAYS.between(anotherDate, currentDate);
        int days = (int) daysDifference;
        if (days > 5){
            int denda = days * 1000;
            return String.valueOf(denda);
        }else{
            return "0";
        }
    }
}
