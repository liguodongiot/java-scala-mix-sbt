package scalacookbook.chapter13

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random

/**
  * Created by liguodong on 2016/8/14.
  */
object SimpleConcurrencyFutureMultiple extends App {

  import scalacookbook.chapter13.section09._

  //Run multiple things; something depends on them; join them together

  println("starting futures")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")

  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)

  println("before onSuccess")
  result onSuccess {
    case result => println(s"total = $result")
  }
  println("before sleep at the end")
  sleep(2000) // keep the jvm alive

  def sleep(time: Long) { Thread.sleep(time) }



  // get the desired info from twitter
  /*
  val dailyTrendsFuture = Future { getDailyTrends(twitter) }
  val usFuture = Future { getLocationTrends(twitter, woeidUnitedStates) }
  val worldFuture = Future { getLocationTrends(twitter, woeidWorld) }
  */



  //Discussion

  //use the fallbackTo method like this:
  //val meaning = calculateMeaningOfLife() fallbackTo 42

  //The andThen combinator gives you a nice syntax for running
  // whatever code you wantto run when a future returns, like this:
  /*
  var meaning = 0
  future {
    meaning = calculateMeaningOfLife()
  } andThen {
    println(s"meaning of life is $meaning")
  }
  */

}

package section09{

  object Cloud {

    def runAlgorithm(i: Int): Future[Int] = Future {

      val sleepTime = Random.nextInt(500)
      println(Thread.currentThread().getName+" waitTime:"+sleepTime)
      Thread.sleep(sleepTime)
      val result = i + 10
      println(Thread.currentThread().getName+s" returning result from cloud: $result")
      result

    }


  }
}
