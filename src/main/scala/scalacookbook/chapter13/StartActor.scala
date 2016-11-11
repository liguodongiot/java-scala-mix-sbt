package scalacookbook.chapter13

import akka.actor._

/**
  * Created by liguodong on 2016/8/13.
  */

object StartActor extends App{

  import scalacookbook.chapter13.section05._

  val actorSystem = ActorSystem("ParentChildTest")
  val parent = actorSystem.actorOf(Props[Parent], name = "Parent")

  // send messages to Parent to create to child actors
  parent ! CreateChild("Jonathan")
  parent ! CreateChild("Jordan")
  Thread.sleep(500)

  // lookup Jonathan, then kill it
  println("Main:Sending Jonathan a PoisonPill ...")
  val jonathan = actorSystem.actorSelection("/user/Parent/Jonathan")
  jonathan ! PoisonPill

  println("Main:jonathan was killed")
  Thread.sleep(5000)
  println("waiting 5 s.")
  actorSystem.shutdown

  //The Child actor could have been created when the Parent actor received a message,
  //so in a sense, that gives you a way to control when an actor
  //instance is created.


}

package section05 {

  case class CreateChild(name: String)

  case class Name(name: String)

  class Child extends Actor {

    var name = "No name"

    override def postStop {
      println(s"D'oh! They killed me ($name): ${self.path}")
    }

    def receive = {
      case Name(name) => this.name = name
      case _ => println(s"Child $name got message")
    }
  }

  class Parent extends Actor {
    def receive = {
      case CreateChild(name) =>
        // Parent creates a new Child here
        println(s"Parent about to create Child ($name) ...")
        val child = context.actorOf(Props[Child], name = s"$name")
        child ! Name(name)
      case _ => println(s"Parent got some other message.")
    }
  }

}