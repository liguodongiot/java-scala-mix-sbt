package akkainaction.actor

import akka.actor.ActorDSL._
import akka.actor.{Actor, ActorSystem}

/**
  * Created by liguodong on 2016/11/16.
  */
object MyActorDslMain extends App {


  import akka.actor.ActorDSL._
  import akka.actor.ActorSystem

//  implicit val system = ActorSystem("demo")
//  val a = actor(new Act {
//    become {
//      case "hello" ⇒
//        println("oo")
//        sender() ! "hi"
//    }
//  })
//  a ! "hello"

  import MyActorDsl._
  createActor ! "hello"

}



object MyActorDsl {
  implicit val system = ActorSystem("demo")
  def createActor = {
    actor(new Act {
      become {
        case "hello" =>
          println("xxx")
          sender ! "hi"
      }
    })
  }
}


