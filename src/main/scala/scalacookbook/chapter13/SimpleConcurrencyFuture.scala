package scalacookbook.chapter13

// 1 - the imports
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by liguodong on 2016/8/14.
  */
object SimpleConcurrencyFuture extends App {

  /*Run one task, but block*/

  def sleep(time: Long) { Thread.sleep(time) }

  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis
  // 2 - create a Future
  val f = Future {
    sleep(500)
    1 + 1
  }
  // 3 - this is blocking (blocking is bad)
  val result = Await.result(f, 1 second)
  println(result)
  sleep(1000)


  //The code also shows a time duration of 1 second.
  //This is made available by the scala.concurrent.duration._ import.

  //With this library, you can state time durations in several convenient ways,
  // such as 100 nanos, 500 millis, 5 seconds, 1 minute,
  // 1 hour, and 3 days. You can also create a duration as
  // Duration(100, MILLISECONDS),Duration(200, "millis").



  //As mentioned, blocking is bad;
  // you shouldn’t write code like this unless you have to.
  // the following examples show better approaches.

}

