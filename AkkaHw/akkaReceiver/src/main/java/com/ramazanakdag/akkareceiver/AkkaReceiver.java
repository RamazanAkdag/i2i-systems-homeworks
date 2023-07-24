
package com.ramazanakdag.akkareceiver;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import akka.event.Logging;
import akka.event.LoggingAdapter;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.Scanner;
/**
 *
 * @author RamazanFirat
 */
public class AkkaReceiver extends AbstractActor{
     private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
   public static Props props() {
        return Props.create(AkkaReceiver.class);
    }

    @Override
public AbstractActor.Receive createReceive() {
        
    return receiveBuilder()
                .match(String.class, message -> {
                    System.out.println("Received message: "+ message);

                    // Send a message back to the sender actor in akkaDemo1
                    getSender().tell("Hi from Actor2", getSelf());
                })
                .build();
}
    
     public static void main(String[] args) {
         
         
       //Configuring remote access and port
        Config config = ConfigFactory.load("application.conf");

        // Create the actor system
        ActorSystem system = ActorSystem.create("ReceiverSystem", config);

        // Create the receiver actor
        ActorRef receiver = system.actorOf(Props.create(AkkaReceiver.class), "receiver");

        System.out.println("You can write 0 to quit anytime");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (!input.equals("0")){
            input = scan.next();
        }
        system.terminate();
        
       
    }
}
