
package com.mycompany.kafkaproducer;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;



public class Producer {

    

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "g1");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
       
        Random random = new Random();

        while (true) {
            String subscId = String.valueOf(random.nextInt(10000));
            String subscName = "Subscriber " + subscId;
            String subscSurname = "Surname " + subscId;
            String msisdn = "0531" + String.valueOf(random.nextInt(999999));
            
            ProducerRecord<String, String> record = new ProducerRecord<>("topic10", subscId,
                    "SUBSC_ID=" + subscId + ", SUBSC_NAME=" + subscName + ", SUBSC_SURNAME="
                            + subscSurname + ", MSISDN=" + msisdn);
            //System.out.println("sent :"+record.toString());
            producer.send(record);
            System.out.println("sent :"+record.toString());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //producer.close();
    }
}