

package com.ramazanakdag.akkasender;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AkkaSender extends AbstractActor {
  private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
  
  public static Props props() {
        return Props.create(AkkaSender.class);
    }

@Override
public Receive createReceive() {
  return receiveBuilder()
      .match(
          String.class,
          s -> {
            log.info("Sending String message: {}", s);
            ActorRef receiver = getContext().actorSelection("akka.tcp://ReceiverSystem@localhost:2553/user/receiver").anchor();
            receiver.tell(s, getSelf());
          })
      .matchAny(o -> log.info("received unknown message"))
      .build();
}
  
    public static void main(String[] args) {
       //Configuring remote access and port
        Config config = ConfigFactory.load("application.conf");

        // Create the actor system
        ActorSystem system = ActorSystem.create("SenderSystem", config);
        
        

        // Create the sender actor
        ActorRef sender = system.actorOf(AkkaSender.props(), "sender");
        
       

        // Send a message from the sender actor to the receiver actor in akkaDemo2
        sender.tell("Hi from sender", ActorRef.noSender());


        
        
    }
}
