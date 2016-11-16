package scalacookbook.chapter13

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

/**
  * Created by liguodong on 2016/8/14.
  */
object SimpleConcurrencyFutureCallback extends App {

  //Run one thing, but don’t block—use callback

  //There are three callback methods: onComplete, onSuccess, and onFailure.
  println("starting calculation ...")
  val f = Future {
    sleep(Random.nextInt(500))
    42
  }

  println("before onComplete")

  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
  }
  // do the rest of your work
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
  sleep(2000)


  def sleep(time: Long) { Thread.sleep(time) }
}
