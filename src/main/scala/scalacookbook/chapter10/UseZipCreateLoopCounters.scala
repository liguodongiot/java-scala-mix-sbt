package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object UseZipCreateLoopCounters extends App{

  val days = Array("Sunday", "Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday")

  days.zipWithIndex.foreach {
    case(day, count) => println(s"$count is $day")
  }

  println("~~~~~~~~~~~~~~~~")

  for ((day, count) <- days.zipWithIndex) {
    println(s"$count is $day")
  }

  println("~~~~~~~~~~~~~~~~")


  // You can also use the zip method with a Stream to create a counter.
  // This gives you a way to control the starting value.
  for ((day,count) <- days.zip(Stream from 1)) {
    println(s"day $count is $day")
  }

  val list = List("a", "b", "c")

  val zwi = list.zipWithIndex
  println(zwi)

  val zwi2 = list.view.zipWithIndex
  println(zwi2)

  println("~~~~~~~~~~~~~~~~")

  days.zipWithIndex.foreach { d =>
    println(s"${d._2} is ${d._1}")
  }

  println("~~~~~~~~~~~~~~~~")

  val fruits = Array("apple", "banana", "orange")
  for (i <- 0 until fruits.size) println(s"element $i is ${fruits(i)}")

  println("~~~~~~~~~~~~~~~~")

  val it = Iterator(1,2,3)
  it.foreach(println)
  //But when you attempt the same call a second time,
  // you won’t get any output, because the iterator has been exhausted.
  it.foreach(println)
  println("~~~~~~~~~~~~~~~~")
  val it2 = Iterator(1,2,3)
  println(it2.toArray.mkString(","))

  //it.to[Tab]
  /*
  toArray toBuffer toIndexedSeq toIterable toIterator
  toList toMap toSeq toSet toStream
  toString toTraversable
  */
}
