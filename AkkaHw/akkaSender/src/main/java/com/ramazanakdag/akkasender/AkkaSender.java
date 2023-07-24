

package com.ramazanakdag.akkasender;
import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;

import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import scala.concurrent.Future;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Scanner;


public class AkkaSender extends AbstractActor {

   
    private final ActorSelection receiverActor;
    private final int disconnectWaitTime;

    /*public static Props props() {
        return Props.create(AkkaSender.class);
    }*/
    public AkkaSender() {
        ActorSystem system = getContext().getSystem();
        this.receiverActor = system.actorSelection("akka.tcp://ReceiverSystem@localhost:2552/user/receiver");
        this.disconnectWaitTime = 5;
    }
    @Override
    public Receive createReceive() {
          return receiveBuilder()
                .match(String.class, message -> {
                    Timeout timeout = new Timeout(Duration.create(disconnectWaitTime, TimeUnit.SECONDS));
                    Future<Object> future = (Future<Object>) Patterns.ask(receiverActor, message, timeout);
                    String result = (String) Await.result(future, timeout.duration());
                    System.out.println("Received response: " + result);
                })
                .build();
    }

    public static void main(String[] args) {
        //Configuring remote access and port
        Config config = ConfigFactory.load("application.conf");

        // Create the actor system
        ActorSystem system = ActorSystem.create("SenderSystem", config);

        // Create the sender actor
        ActorRef sender = system.actorOf(Props.create(AkkaSender.class), "sender");

        // Send a message from the sender actor to the receiver actor in akkaDemo2
        sender.tell("Hi from Actor1", ActorRef.noSender());

        System.out.println("You can write 0 to quit anytime");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (!input.equals("0")){
            input = scan.next();
        }
        system.terminate();

    }
}