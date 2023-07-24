
package com.ramazanakdag.voltdbhw;


import java.sql.*;
import java.io.*;

public class VoltDbHw {

    public static void main(String[] args) {
 
        String driver = "org.voltdb.jdbc.Driver";
        String url = "jdbc:voltdb://localhost:32768";
       
        //String sql = "SELECT dialect FROM helloworld";
        String sql = "SELECT * FROM SUBSCRIBER";
        try {
                // Load driver. Create connection.
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);
            
                // create a statement
            Statement query = conn.createStatement();
            ResultSet resultSet = query.executeQuery(sql);
            while (resultSet.next()) {
                int subscId = resultSet.getInt("SUBSC_ID");
                String name = resultSet.getString("SUBSC_NAME");
                String surname = resultSet.getString("SUBSC_SURNAME");
                String msisdn = resultSet.getString("MSISDN");
                int tariffId = resultSet.getInt("TARIFF_ID");
                Date startDate = resultSet.getDate("START_DATE");

                System.out.println("SUBSC_ID: " + subscId + ", SUBSC_NAME: " + name +
                        ", SUBSC_SURNAME: " + surname + ", MSISDN: " + msisdn +
                        ", TARIFF_ID: " + tariffId + ", START_DATE: " + startDate);
            }
            
                 
            resultSet.close();
            query.close();
            conn.close();

        } catch (Exception e) {
           e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }
}
