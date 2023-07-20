/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramazanakdag.hazelcast2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

class HIZTEST{
    int key;
    
    
}
/**
 *
 * @author RamazanFirat
 */
public class oracleSqlDemo {
    public static void main(String[] args) {
      
      String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
       String username = "SYS";
        String password = "12345";
        
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        properties.setProperty("internal_logon", "sysdba"); 
      Connection conn = null;
       try {
           conn = DriverManager.getConnection(dbURL,properties);
           Statement statement = conn.createStatement();
           ResultSet resultSet;
            
           System.out.println("---------------inserting 20000 values---------------------");
           Long begin = System.currentTimeMillis();
           for(int i = 0; i<20000;i++){//insert 20000 random number into database
                int randomValue = (int) (Math.random() * 100); // 0 ile 99 arasında rasgele bir tamsayı elde edin
                String insertQuery = "INSERT INTO HIZTEST VALUES (" + i + ")";
                statement.executeUpdate(insertQuery);
           }
           Long end = System.currentTimeMillis();
           long runtime = end - begin;
           System.out.println("insert runtime : "+runtime);
            
           System.out.println("---------------getting 1000000 values---------------------");
           
           begin = System.currentTimeMillis();
           for(int i = 0 ; i< 100000; i++){
               int randomValue = (int) (Math.random() * 20000);
               String selectQuery = "select * from HIZTEST where KEY = "+ randomValue;
               resultSet = statement.executeQuery(selectQuery);
           }
           end = System.currentTimeMillis();
           runtime = end - begin;
           System.out.println("get results runtime : "+runtime);
           
           System.out.println("delete---------------------------------");
            String deleteQuery = "DELETE FROM HIZTEST";
            statement.executeUpdate(deleteQuery);
            
            // Veritabanı bağlantısı başarılı, burada işlemlerinizi yapabilirsiniz
        } catch (SQLException ex) {
            Logger.getLogger(oracleSqlDemo.class.getName()).log(Level.SEVERE, null, ex);
            // Bağlantı hatası
        } finally{
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(oracleSqlDemo.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
         
        
    }
    
}
