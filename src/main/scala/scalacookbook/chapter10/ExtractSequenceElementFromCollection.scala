package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/25.
  */
object ExtractSequenceElementFromCollection extends App{

  val x = (1 to 10).toArray
  val y = x.drop(3)  //删除前三个元素
  println(y.toVector)

  val y2 = x.dropWhile(_ < 6) //删除小于6的元素
  println(y2.toList)

  val y3 = x.dropRight(4)  //删除末尾4个元素
  println(y3.toSeq)

  val y4 = x.take(3)  //保留前三个元素
  println(y4.toList)

  val y5 = x.takeWhile(_ < 5) //保留小于5的元素
  println(y5.toList)

  val y6 = x.takeRight(3)   //保留后三个元素
  println(y6.toList)

  println("------------------")

  val peeps = List("John", "Mary", "Jane", "Fred", "ddd","cccc","yyyy")

  //保留索引大于等于1 并且小于4的元素
  val y7 = peeps.slice(1,4)
  println(y7)

  //Even more methods
  val nums = (1 to 5).toArray

  println(nums.head+", "+nums.headOption+", "+
    nums.last+", "+ nums.lastOption)

  //保留除了最后一个元素之外的元素
  nums.init.foreach(print)
  println()

  //保留除了第一个元素之外的元素
  nums.tail.foreach(print)

}
