package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object LoopCollectionForLoop extends App{

  //fruits: Traversable[String] = List(apple, banana, orange)
  val fruits = Traversable("apple", "banana", "orange")

  for (f <- fruits) println(f)

  for (f <- fruits) println(f.toUpperCase)


  //fruits: Array[String] = Array(apple, banana, orange)
  val fruits2 = Array("apple", "banana", "orange")
  for (f <- fruits2) {
    // imagine this required multiple lines
    val s = f.toUpperCase
    println(s)
  }

  for (i <- 0 until fruits2.size) println(s"element $i is ${fruits2(i)}")

  for ((elem, count) <- fruits2.zipWithIndex) {
    println(s"element $count is $elem")
  }

  //使计数器从1开始
  //Using zip with a Stream is another way to generate a counter
  for ((elem,count) <- fruits2.zip(Stream from 1)) {
    println(s"element $count is $elem")
  }

  val newArray = for (e <- fruits2) yield e.toUpperCase


  val newArray2 = for (fruit <- fruits) yield {
    // imagine this required multiple lines
    val upper = fruit.toUpperCase
    upper
  }


  def upperReverse(s: String) = {
    // imagine this is a long algorithm
    s.toUpperCase.reverse
  }

  val newArray3 = for (fruit <- fruits2) yield upperReverse(fruit)

  //Maps
  val names = Map("fname" -> "Ed", "lname" -> "Chigliak")
  for ((k,v) <- names) println(s"key: $k, value: $v")


  //Discussion
  for (i <- 1 to 3) { // more code here ...
  }

  /*
  for {
    file <- files
    if file.isFile
    if file.getName.endsWith(".txt")
  } doSomething(file)
  */

}
