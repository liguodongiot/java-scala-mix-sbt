package scalacookbook.chapter13

import akka.actor.ActorSystem

/**
  * Created by liguodong on 2016/8/13.
  */
object ShutDownAkkaActor extends App{

  // create the ActorSystem
  val system = ActorSystem("HelloSystem")
  // put your actors to work here ...
  // shut down the ActorSystem when the work is finished
  system.shutdown

}
