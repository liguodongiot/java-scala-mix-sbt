package scalainaction.actor

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

/**
  * Created by liguodong on 2016/11/16.
  */

object MyActorWithParamMain extends App{

  //如果创建的Actor类需要传入构造函数参数，则使用Props对象的方式会有所变化.
  val system = ActorSystem("mySystem")

  val actorWithArgs = system.actorOf(Props(classOf[ActorWithArgs], "arg"), "actorWithArgs")

  actorWithArgs ! "test"

  actorWithArgs ! "aaa"

}

class ActorWithArgs(arg: String) extends Actor{

  //Akka推荐的一个实践是为自定义Actor建立伴生对象（ companion object） ，
  //提供创建Props对象的工厂方法。这有利于为Props的创建建立一个单一引用点。
  //当Actor的创建发生变化时，可以只修改工厂方法.

  val demoActor = context.actorOf(DemoActor.props("name"),"demoActor")

  val log = Logging(context.system, this)

  def receive = {
    case "test" =>
      log.info("received test, " + arg)
      demoActor ! "hahaha"
    case _ =>
      log.info("received unknown message, " + arg)
      demoActor ! "kokoko"
  }

}


object DemoActor {
  def props(name: String): Props = Props(classOf[DemoActor], name)
}

class DemoActor(name:String) extends Actor {

  def receive = {
  case "hahaha" =>
    //some behaviour
    println("hahaha")
  case _ =>
    //unknown message
    println("nonono")
  }
}

