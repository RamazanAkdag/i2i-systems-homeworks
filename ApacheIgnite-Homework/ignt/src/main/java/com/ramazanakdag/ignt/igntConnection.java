
package com.ramazanakdag.ignt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class igntConnection{
    public static void main(String[] args) throws SQLException {
        Connection conn = null ;
        try {
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            conn = DriverManager.getConnection("jdbc:ignite:thin://localhost:32772");
            String query = "SELECT SUBSC_ID,SUBSC_NAME,SUBSC_SURNAME,MSISDN,TARIFF_ID,START_DATE from SUBSCRIBER";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                int SUBSC_ID = result.getInt("SUBSC_ID");
                String SUBSC_NAME = result.getString("SUBSC_NAME");
                String SUBSC_SURNAME = result.getString("SUBSC_SURNAME");
                String MSISDN = result.getString("MSISDN");
                int TARIFF_ID = result.getInt("TARIFF_ID");
                String START_DATE = result.getString("START_DATE");
                
                System.out.println("SUBSC_ID : "+SUBSC_ID+"\nSUBSC_NAME : "+SUBSC_NAME +
                        "\nSUBSC_SURNAME : " +SUBSC_SURNAME +
                        "\nMSISDN : "+MSISDN + "\nTARIFF_DATE : "+TARIFF_ID);
                
                System.out.println("____________________________________________");
                
                
                
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(igntConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conn.close();
        }
        
    }
}