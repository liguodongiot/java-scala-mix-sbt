package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/25.
  */
object ExtractSequenceElementFromCollection extends App{

  val x = (1 to 10).toArray
  val y = x.drop(3)
  println(y)
  val y2 = x.dropWhile(_ < 6)
  println(y2)
  val y3 = x.dropRight(4)
  println(y3)
  val y4 = x.take(3)
  println(y4)

  val y5 = x.takeWhile(_ < 5)
  println(y5)
  val y6 = x.takeRight(3)
  println(y6)

  val peeps = List("John", "Mary", "Jane", "Fred")

  val y7 = peeps.slice(1,3)
  println(y7)

  //Even more methods
  val nums = (1 to 5).toArray

  println(nums.head+", "+nums.headOption+", "+
    nums.last+", "+ nums.lastOption)
  nums.init.foreach(print)
  println()
  nums.tail.foreach(print)

}
