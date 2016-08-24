package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/24.
  */
object BuildFunctionTypes extends App {

  //Example 1: Creating a Timer
  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta/1000000d)
  }

  //val (result, time) = timer(someLongRunningAlgorithm)


  val (result, time) = timer {
    Thread.sleep(500);
    1
  }
  println(s"result: $result, time: $time")

  val (result2, time2) = timer{ println("Hello") }
  println(s"result2: $result2, time2: $time2")

  
}