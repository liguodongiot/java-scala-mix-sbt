package akkainaction.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by liguodong on 2016/11/16.
  */
object PreMyActorMain extends App {


  val system = ActorSystem("actorSystem")
  val actor1: ActorRef = createActor(system, "actor1")
  val actor2: ActorRef = createActor(system, "actor2")
  val actor3: ActorRef = createActor(system, "actor3")
  val actor4: ActorRef = createActor(system, "actor4")
  val actor5: ActorRef = createActor(system, "actor5")

  def createActor(system: ActorSystem, actorName: String):ActorRef = {
    system.actorOf(Props[MyActorPre], actorName)
  }


}

class MyActorPre extends Actor {

  override def preStart(): Unit = {
    println(s"Start actor ${self}")
    super.preStart()
  }

  override def receive ={
    case _ =>
      println("less")
  }

}

