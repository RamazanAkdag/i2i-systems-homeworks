
package com.ramazanakdag.akkareceiver;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import akka.event.Logging;
import akka.event.LoggingAdapter;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
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
public Receive createReceive() {
  return ReceiveBuilder.create()
      .match(
          String.class,
          message -> {
            log.info("Received message: {}", message);
            getSender().tell("Hello from Receiver", getSelf());
          })
      .matchAny(message -> System.out.println("Unknown message!"))
      .build();
}
    
     public static void main(String[] args) {
         Config config = ConfigFactory.load("application.conf");
        ActorSystem system = ActorSystem.create("ReceiverSystem", config);
        ActorRef receiver = system.actorOf(AkkaReceiver.props(), "receiver");
        /*if(receiver != null)
             System.out.println("null değil"+receiver);*/
        
       
    }
}
