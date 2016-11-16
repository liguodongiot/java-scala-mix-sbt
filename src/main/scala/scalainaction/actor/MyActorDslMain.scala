package scalainaction.actor

import akka.actor.ActorDSL._
import akka.actor.{Actor, ActorSystem}

/**
  * Created by liguodong on 2016/11/16.
  */
object MyActorDslMain extends App {

  /////////////////////////////////
  /////////

}



class MyActorDsl {
  implicit val system = ActorSystem("demo")
  def createActor = {
    actor(new Act {
      become {
        case "hello" => sender ! "hi"
      }
    })
  }
}


class HotSwapActor extends Actor {
  import context._

  def angry: Receive = {
    case "foo" ⇒ sender ! "I am already angry?"
    case "bar" ⇒ become(happy)
  }

  def happy: Receive = {
    case "bar" ⇒ sender ! "I am already happy :-)"
    case "foo" ⇒ become(angry)
  }

  def receive = {
    case "foo" ⇒ become(angry)
    case "bar" ⇒ become(happy)
  }

}
