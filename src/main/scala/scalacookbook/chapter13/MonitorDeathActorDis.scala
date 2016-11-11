package scalacookbook.chapter13

import akka.actor.{ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/14.
  */
object MonitorDeathActorDis extends App{

  import scalacookbook.chapter13.section08.discussion._
  //Discussion
  // create the ActorSystem instance
  val system = ActorSystem("DeathWatchTest")

  // create the Parent that will create Kenny
  val parent = system.actorOf(Props[Parent2], name = "Parent2")

  // lookup kenny, then kill it
  val kenny = system.actorSelection("/user/Parent2/Kenny")
  //kenny ! PoisonPill
  //kenny ! Explode

  //
  kenny ! "Hello?"

  Thread.sleep(5000)
  println("calling system.shutdown")
  system.shutdown



  //Looking up actors 查看Actor

  //1
  //val kenny = system.actorSelection("/user/Parent/Kenny")

  //2
  //You can also look up actors using a relative path.
  // If kenny had a sibling actor,
  // it could have looked up kenny using its own context.

  // in a sibling actor
  //val kenny = context.actorSelection("../Kenny")

  //3
  //use various implementations of the actorFor method to look up actors.

  //val kenny = system.actorFor("akka://DeathWatchTest/user/Parent/Kenny")
  //val kenny = system.actorFor(Seq("user", "Parent", "Kenny"))


  //4
  //It could also be looked up from a sibling like this:
  //val kenny = system.actorFor(Seq("..", "Kenny"))
}

package section08.discussion {

  import akka.actor.{Actor, Terminated}

  //An important thing to understand is that
  // if the Kenny actor throws an exception, this
  // doesn’t kill it. Instead it will be restarted.
  case object Explode

  class Kenny extends Actor {

    def receive = {
      case Explode => throw new Exception("Boom!")
      case _ => println("Kenny received a message")
    }
    override def preStart { println("kenny: preStart") }
    override def postStop { println("kenny: postStop") }

    override def preRestart(reason: Throwable, message: Option[Any]) {
      println("kenny: preRestart")
      super.preRestart(reason, message)
    }
    override def postRestart(reason: Throwable) {
      println("kenny: postRestart")
      super.postRestart(reason)
    }
  }

  class Parent2 extends Actor {
    // start Kenny as a child, then keep an eye on it
    val kenny = context.actorOf(Props[Kenny], name = "Kenny")
    context.watch(kenny)

    def receive = {
      case Terminated(kenny) => println("OMG, they killed Kenny")
      case _ => println("Parent received a message")
    }
  }



}