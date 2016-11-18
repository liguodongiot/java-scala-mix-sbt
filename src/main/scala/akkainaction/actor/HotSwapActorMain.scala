package akkainaction.actor

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/11/18.
  */
object HotSwapActorMain extends App{

  val system = ActorSystem("mySystem")

  val hotSwapActor = system.actorOf(Props[HotSwapActor], "hotSwapActor")

  hotSwapActor ! "foo"
  hotSwapActor ! "foo"

  hotSwapActor ! "bar"
  hotSwapActor ! "bar"

}


class HotSwapActor extends Actor {

  import context._

  def angry: Receive = {
    case "foo" ⇒
      println("I am already angry?")
      //sender ! "I am already angry?"
    case "bar" ⇒ become(happy)
  }

  def happy: Receive = {
    case "bar" ⇒
      println("I am already happy :-)")
      //sender ! "I am already happy :-)"
    case "foo" ⇒ become(angry)
  }

  def receive = {
    case "foo" ⇒ become(angry)
    case "bar" ⇒ become(happy)
  }

}
