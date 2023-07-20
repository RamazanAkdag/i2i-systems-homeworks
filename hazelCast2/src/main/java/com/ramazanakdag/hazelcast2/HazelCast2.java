/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ramazanakdag.hazelcast2;
import com.hazelcast.cluster.Cluster;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import java.util.Queue;
/**
 *
 * @author RamazanFirat
 */
public class HazelCast2 {

    public static void main(String[] args) {
       Config cfg = new Config();
       HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
       Map<Integer, Integer> mapNumbers = instance.getMap("number");
       Cluster cluster = instance.getCluster();
       
       
       
       
        /*mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");*/
        System.out.println("---------inserting 20000 values------");
        long begin = System.currentTimeMillis();
        for(int i = 0 ; i< 20000; i++){//clustering 20000 numbers
            mapNumbers.put(i,(int) (Math.random()*100));
        }
        long end = System.currentTimeMillis();
        
        int runtime = (int) (end - begin);
        
        System.out.println("\ninserted successfully - put runtime : "+runtime);
        //one of the put runtime results is 511
        System.out.println("---------getting 100000 values------");
        //Getting
        begin = System.currentTimeMillis();
       for(int i = 0 ; i < 100000 ; i++){//get data from cluster for 100000 times
           int data = mapNumbers.get((int) (Math.random()*20000));
          
       }
      
        end = System.currentTimeMillis();
        runtime = (int) (end - begin);
        System.out.println("\n completed successfully -get runtime : "+runtime);
        //one of the get results is 938
    }
}
