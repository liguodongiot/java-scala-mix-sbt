package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object LoopCollectionWithForeach extends App{

  val x = Vector(1, 2, 3)
  x.foreach((i: Int) => println(i))

  println("==================")

  x.foreach(i => println(i))

  println("==================")

  x.foreach(println(_))

  println("==================")

  x.foreach(println)


  //Discussion
  def printIt(c: Char) { println(c) }

  "HAL".foreach(c => printIt(c))
  "HAL".foreach(printIt)

  "HAL".foreach((c: Char) => println(c))

  val longWords = new StringBuilder
  "Hello world it's Al".split(" ").foreach{ e =>
    if (e.length > 4) longWords.append(s" $e")
    else println("Not added: " + e)
  }

  println(longWords)

  "Hello world it's Al".split(" ").foreach(println)

  println("----------------")

  // handle those parameters as a tuple
  val m = Map("fname" -> "Tyler", "lname" -> "LeDude")
  m foreach (x => println(s"${x._1} -> ${x._2}"))


  // prefer the following approach
  m.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
  }

}
