package scalacookbook.chapter13

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/13.
  */

object StartSimpleActor extends App{

  import scalacookbook.chapter13.section01._

  // an actor needs an ActorSystem
  val system = ActorSystem("HelloSystem")

  // create and start the actor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  // send the actor two messages
  helloActor ! "hello"
  helloActor ! "buenos dias"

  // shut down the system
  system.shutdown
}

package section01{
  class HelloActor extends Actor {
    def receive = {
      case "hello" => println("hello back at you")
      case _ => println("huh?")
    }
  }
}

