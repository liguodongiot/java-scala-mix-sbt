package scalacookbook.chapter13

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/13.
  */

object UnderstandActorLifecycle extends App{

  import scalacookbook.chapter13.section04._

  val system = ActorSystem("LifecycleDemo")

  val kenny = system.actorOf(Props[Kenny], name = "Kenny")

  println("Main:sending kenny a simple String message")
  kenny ! "hello"
  Thread.sleep(10000)

  //重启
  println("\n准备重启\nMain:make kenny restart")
  kenny ! ForceRestart
  println("-------------------")
  Thread.sleep(20000)

  kenny ! "what"
  kenny ! "dsaff"

  println("\n准备停止\nMain:stopping kenny")
  system.stop(kenny)
  println("Main:shutting down system")
  system.shutdown


}

package section04{

  case object ForceRestart

  class Kenny extends Actor {

    println("Kenny-->entered the Kenny constructor")

    //Actor开始之前调用
    override def preStart { println("kenny: preStart") }

    //Actor停止之后调用
    override def postStop { println("kenny: postStop") }

    //when an actor is restarted, the old actor is informed of the process
    //when preRestart is called with the exception that caused the restart,
    //and the message that triggered the exception.
    //The message may be None if the restart was not caused by processing a message.
    override def preRestart(reason: Throwable, message: Option[Any]) {
      println("kenny: preRestart")
      println(s" MESSAGE: ${message.getOrElse("")}")
      println(s" REASON: ${reason.getMessage}")
      super.preRestart(reason, message)

    }

    override def postRestart(reason: Throwable) {
      println("kenny: postRestart")
      println(s" REASON: ${reason.getMessage}")
      super.postRestart(reason)
    }

    def receive = {
      case ForceRestart => throw new Exception("Boom!")
      case _ => println("Kenny received a message")
    }

    //the pre* and post* methods can be used to initialize and close
    //resources that your actor requires.

  }

}
