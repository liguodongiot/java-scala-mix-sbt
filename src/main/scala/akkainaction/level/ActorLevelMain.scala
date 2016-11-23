package akkainaction.level

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/11/16.
  */
object ActorLevelMain extends App{

  val system = ActorSystem("testParentChildActors")

  val parentActor = system.actorOf(Props[ParentActor], "ParentActor")

  parentActor ! StartMessage("start")

  //system.shutdown

}


case class ExecutionMessage(msg: String)

case class StartMessage(msg: String)

case class FinishedMessage(msg: String)

class ChildActor extends Actor {

  def receive = {
    case ExecutionMessage(msg) =>
      println(msg) //fake real execution logic
      sender ! FinishedMessage("kill me")
  }

}

class ParentActor extends Actor {

  val child = context.actorOf(Props[ChildActor], "ChildActor")

  def receive = {
    case StartMessage(msg) =>
      println(msg)
      child ! ExecutionMessage("executing child actor")
    case FinishedMessage(msg) =>
      println(msg)
  }

}
