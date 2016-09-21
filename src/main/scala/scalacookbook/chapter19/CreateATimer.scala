package scalacookbook.chapter19

/**
  * Created by liguodong on 2016/8/24.
  */
object CreateATimer extends App {

  //Example 1: Creating a Timer

  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta/1000000d)
  }

  //create a similar timer method in Scala to let you run code
  //val (result, time) = timer(someLongRunningAlgorithm)

  // the timer runs a method named longRunningAlgorithm

  val (result, time) = timer {
    Thread.sleep(500);
    1
  }
  println(s"result: $result, time: $time")

  val (result2, time2) = timer{ println("Hello") }
  println(s"result2: $result2, time2: $time2")

  //Or an algorithm that reads a file and returns an iterator
  def readFile(filename: String) = io.Source.fromFile(filename).getLines

  val (result3, time3) = timer{ readFile("d:\\temp.txt") }
  println(s"result3: $result3, time3: $time3")


}