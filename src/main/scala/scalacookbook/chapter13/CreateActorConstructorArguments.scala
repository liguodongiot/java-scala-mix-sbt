package scalacookbook.chapter13

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/13.
  */
object CreateActorConstructorArguments extends App {

  import scalacookbook.chapter13.section02._

  val system = ActorSystem("HelloSystem")

  // (3) use a different version of the Props constructor
  val helloActor = system.actorOf(
    Props(new HelloActorParam("Fred")), name = "helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"

  system.shutdown

  //If the HelloActor constructor required both a first
  //and last name, you’d specify them like this:
  // Props(new HelloActor("John", "Doe")), name = "helloactor")

}

package section02{

  // (1) constructor changed to take a parameter
  class HelloActorParam(myName: String) extends Actor {
    def receive = {
      // (2) println statements changed to show the na
      case "hello" => println(s"hello from $myName")
      case _ => println(s"'huh?', said $myName")
    }
  }

}
