/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ramazanakdag.akkaframeworkdemo;


import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

/**
 *
 * @author RamazanFirat
 */
class Actor1 extends AbstractBehavior<String>{
    static Behavior<String> create(){
       return Behaviors.setup(Actor1::new );//actor1 aktörnü başlatma
    }

    public Actor1(ActorContext<String> context) {
        super(context);
    }

    @Override
    public Receive<String> createReceive() {
        return newReceiveBuilder().onMessageEquals("start",this::start).onMessageEquals("hi from actor 2", this::sayHelloTo2).build();
    }
    public Behavior<String> sayHelloTo2(){
         ActorRef secondRef = getContext().spawn(Actor2.create(), "second-actor");
           System.out.println("\n\n\n------------------second : hi from actor 2");
           return Behaviors.same();
    }
    public Behavior<String> start(){
        ActorRef secondRef = getContext().spawn(Actor2.create(), "second-actor");//mesaj göndereceği aktörün hangi class olduğunu belirttik
        
        secondRef.tell("hi from actor 1");
        return Behaviors.same();
    }
    
} 


class Actor2 extends AbstractBehavior<String>{//string türünden gelen mesajları kabul edecek bir aktör classı
    static Behavior<String> create(){
       return Behaviors.setup(Actor2::new );//actor1 aktörnü başlatma
    }

    public Actor2(ActorContext<String> context) {
        super(context);
    }


    @Override
    public Receive<String> createReceive() {
      
       
        return newReceiveBuilder().onMessageEquals("hi from actor 1",this::sayHello).build();
      
    }
    
    private Behavior<String> sayHello(){
        ActorRef<String> firstRef = getContext().spawn(Actor1.create(),"first-actor");
        System.out.println("\n\n\n------------------------first : "+"hi from actor 1\n\n\n");
        firstRef.tell("hi from actor 2");
        
//behaviors.empty mesaj alıp vermeyen bir aktör oluşturur
        //empty kullanımı yalnızca ilk tanımlandığında ya da sonlandırıldığında kullanılır
        
        return Behaviors.same();
    }
}



public class Test {
    
    public static void main(String[] args) {
         ActorRef<String> testSystem = ActorSystem.create(Actor1.create(), "testSystem");
         testSystem.tell("start");
        
    }
}