package scalacookbook.chapter13

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by liguodong on 2016/8/14.
  */
object SendMessageActorWaitReply extends App{
  import scalacookbook.chapter13.section10._

  // create the system and actor
  val system = ActorSystem("AskTestSystem")
  val myActor = system.actorOf(Props[TestActor], name = "myActor")

  // (1) this is one way to "ask" another actor for information
  implicit val timeout = Timeout(5 seconds)

  val future = myActor ? AskNameMessage
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(result)

  // (2) a slightly different way to ask another actor for information
  val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]

  val result2 = Await.result(future2, 1 second)
  println(result2)

  system.shutdown

}

package section10{
  case object AskNameMessage

  class TestActor extends Actor {
    def receive = {
      case AskNameMessage => // respond to the 'ask' request
        sender ! "Fred"
      case _ => println("that was unexpected")
    }
  }


  //To keep the previous example simple, only one actor is shown,
  // but the same approach is used by two actors.
  // Just use the ? or ask method in your actor, like this.

  /*
  case object GetName

  class FooActor extends Actor {
    def receive = {
      case GetName =>
        val future: Future[String] = ask(otherActor, AskNameMessage).mapTo[String]
        val result = Await.result(future, 1 second)
      case _ => // handle other messages
    }
  }
  */


}


