package scalainaction.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

import scalainaction.level.StartMessage

/**
  * Created by liguodong on 2016/11/16.
  */
object MyActorMain extends App{

  val system = ActorSystem("mySystem")

  val myActor = system.actorOf(Props[MyActor], "myActor")

  myActor ! "sss"

  myActor ! "test"


  //system.shutdown
}


class MyActor extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case "test" => log.info("received test")
    case _ => log.info("received unknown message")
  }
}

