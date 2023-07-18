/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ramazanakdag.logforjproj;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author RamazanFirat
 */

public class myTimerLoggings {
    static int saniyeSayac = 0;
    static int dakikaSayac = 0;
    static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
      
     
       // Logger logger = LogManager.getLogger();
       // logger.info("selamlar");
        
       Timer timer = new Timer();
        
        TimerTask task =new TimerTask() {
           @Override
           public void run() {
               if(dakikaSayac == 2){
                   timer.cancel();
                   return;
               }
              if(dakikaSayac == 60){
                  logger.error("saat mesajı");
                  dakikaSayac =0;
                  return;
              }
              if(saniyeSayac == 60){
                  logger.info("dakika mesajı");
                  dakikaSayac++;
                  saniyeSayac = 0;
                  return;
              }
              
               logger.debug("saniye mesajı");
               saniyeSayac++;
           }
        };
          
       timer.schedule(task,0,1000);
      
      
      
             
          
        
            
    }
    
    
   
}
