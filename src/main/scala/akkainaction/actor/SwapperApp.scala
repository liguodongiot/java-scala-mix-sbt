package akkainaction.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

/**
  * Created by liguodong on 2016/11/17.
  */
object SwapperApp extends App{

  val system = ActorSystem("SwapperSystem")
  val swap = system.actorOf(Props[Swapper], name = "swapper")
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho
  swap ! Swap // logs Hi
  swap ! Swap // logs Ho

}


case object Swap

class Swapper extends Actor {
  import context._
  val log = Logging(system, this)

  def receive = {
    case Swap ⇒
      log.info("Hi")
      become {
        case Swap ⇒
          log.info("Ho")
          unbecome() // 重置最近的 'become' (完全为了好玩)
      }
  }

}

