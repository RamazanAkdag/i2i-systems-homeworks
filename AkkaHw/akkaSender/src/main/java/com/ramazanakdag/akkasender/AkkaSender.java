

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
   
        Config config = ConfigFactory.load("application.conf");

        ActorSystem system = ActorSystem.create("SenderSystem", config);
        ActorRef sender = system.actorOf(AkkaSender.props(), "sender");
      
        sender.tell("Hi from sender", ActorRef.noSender());//send message to itself


        
        
    }
}
