package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object TransformOneCollectionForYield extends App {

  val a = Array(1, 2, 3, 4, 5)

  val eCopy = for (e <- a) yield e
  println(eCopy.toList)

  val eDouble = for (e <- a) yield e * 2
  println(eDouble.toList)

  val e2 = for (e <- a) yield e % 2
  println(e2.toList)

  println("----------------")

  val fruits = Vector("apple", "banana", "lime", "orange")

  val ucFruits = for (e <- fruits) yield e.toUpperCase
  println(ucFruits)


  // converts the original collection into a sequence of Tuple2 elements
  val indexVector = for (i <- 0 until fruits.length) yield (i, fruits(i))
  println(indexVector)

  //a sequence of Tuple2 elements that contains each original string
  //along with its length.
  val f = for (f <- fruits) yield (f, f.length)
  println(f)

  val x = for (e <- fruits) yield {
    // imagine this required multiple lines
    val s = e.toUpperCase
    s
  }
  println(x)

  println("---------------")

  case class Person (name: String)
  val friends = Vector("Mark", "Regina", "Matt")

  val person = for (f <- friends) yield Person(f)
  println(person)

  val x2 = for (e <- fruits if e.length < 6) yield e.toUpperCase
  println(x2)


  //Discussion
  val fruits2 = scala.collection.mutable.ArrayBuffer("apple", "banana")

  val x3 = for (e <- fruits2) yield e.toUpperCase
  println(x3)

  println("=====================")
  val fruits3 = "apple" :: "banana" :: "orange" :: Nil
  val x4 = for (e <- fruits3) yield e.toUpperCase
  println(x4)

  //Using guards

  val cars = Vector("Mercedes", "Porsche", "Tesla")
  val filterResult = for {
    c <- cars
    if c.startsWith("M")
  } yield c

  println(filterResult)
}
