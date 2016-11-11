package scalacookbook.chapter13

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

/**
  * Created by liguodong on 2016/8/14.
  */
object SimpleConcurrencyFutureCallbackSucFai extends App{

  val f = Future {
    sleep(Random.nextInt(500))
    if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
  }
  f onSuccess {
      case result => println(s"Success: $result")
    }

  f onFailure {
      case t => println(s"Exception: ${t.getMessage}")
    }

  // do the rest of your work
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  sleep(2000)

  //the onSuccess and onFailure blocks are defined as partial functions;
  //they only need to handle their expected conditions.


  def sleep(time: Long) { Thread.sleep(time) }
}
