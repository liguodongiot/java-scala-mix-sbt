package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object TransformOneCollectionForYield extends App {

  val a = Array(1, 2, 3, 4, 5)
  for (e <- a) yield e

  for (e <- a) yield e * 2

  for (e <- a) yield e % 2

  val fruits = Vector("apple", "banana", "lime", "orange")

  val ucFruits = for (e <- fruits) yield e.toUpperCase

  // converts the original collection into a sequence of Tuple2 elements
  for (i <- 0 until fruits.length) yield (i, fruits(i))

  //a sequence of Tuple2 elements that contains each original string
  //along with its length.
  for (f <- fruits) yield (f, f.length)

  val x = for (e <- fruits) yield {
    // imagine this required multiple lines
    val s = e.toUpperCase
    s
  }

  case class Person (name: String)
  val friends = Vector("Mark", "Regina", "Matt")

  for (f <- friends) yield Person(f)

  val x2 = for (e <- fruits if e.length < 6) yield e.toUpperCase

  //Discussion
  val fruits2 = scala.collection.mutable.ArrayBuffer("apple", "banana")

  val x3 = for (e <- fruits2) yield e.toUpperCase

  println("=====================")
  val fruits3 = "apple" :: "banana" :: "orange" :: Nil
  val x4 = for (e <- fruits3) yield e.toUpperCase

  //Using guards

  val cars = Vector("Mercedes", "Porsche", "Tesla")
  for {
    c <- cars
    if c.startsWith("M")
  } yield c


}
