package scalaprogram.chapter30

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by liguodong on 2016/11/16.
  */
object SillyActorMain extends App{

  val system = ActorSystem("HelloAkka")
  //创建具体的SillyActor
  val sillyActor = system.actorOf(Props[SillyActor],name = "sillyActor")
  println("sillyActor:"+sillyActor.path)
  sillyActor ! "1,2,3,go..."

  val seriousActor = system.actorOf(Props[SeriousActor],name = "seriousActor")
  println("seriousActor:"+seriousActor.path)
  seriousActor ! "go..."


  //system.shutdown()
}

class SillyActor extends Actor{
  override def receive ={
    case _ =>
    for(i <- 1 to 5){
      println("I'm comming...")
      Thread.sleep(500)
    }
  }
}

class SeriousActor extends Actor{
  override def receive: Receive = {
    case _ =>
      for(i <- 1 to 5){
        println("To be or not to be...")
        Thread.sleep(1000)
      }
  }
}


