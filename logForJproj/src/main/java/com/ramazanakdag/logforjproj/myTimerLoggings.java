/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramazanakdag.logforjproj;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author RamazanFirat
 */

public class myTimerLoggings {
   /* static int saniyeSayac = 0;
    static int dakikaSayac = 0;*/
    static final Logger logger = LogManager.getLogger();
    //1 saniye geriden başlasın 
    public static void main(String[] args) {
      
     
       // Logger logger = LogManager.getLogger();
       // logger.info("selamlar");
      LocalTime previousTime = LocalTime.now().minusSeconds(1);//çalıştuığı ilk saniyeden başlaması için 1 saniye geri alıyoruz
      while(true){
          LocalTime currentTime = LocalTime.now();
          
          if(previousTime.getSecond() != currentTime.getSecond()){
              logger.debug("saniye değişti");
          }
          if(previousTime.getMinute() != currentTime.getMinute()){
              logger.info("dakika değişti");
          }
          if(previousTime.getHour() != currentTime.getHour() ){
              logger.error("saat değişti");
          }
          
          try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              java.util.logging.Logger.getLogger(myTimerLoggings.class.getName()).log(Level.SEVERE, null, ex);
          }
          previousTime = currentTime;//şimdiki zamanı önceki zaman olarak atayıp bir sonraki tura geçiyoruz
      }
      
      
      
             
          
        
            
    }
    
    
   
}
