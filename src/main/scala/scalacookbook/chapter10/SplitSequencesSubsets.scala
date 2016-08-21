package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/25.
  */
object SplitSequencesSubsets extends App{

  val x = List(15, 10, 5, 8, 20, 12)
  val y = x.groupBy(_ > 10)
  println(y)
  val y2 = x.partition(_ > 10)
  println(y2)
  val y3 = x.span(_ < 20)
  println(y3)
  val y31 = x.span(_ > 5)
  println(y31)

  val y4 = x.splitAt(2)
  println(y4)
  val y41 = x.splitAt(4)
  println(y41)

  val (a,b) = x.partition(_ > 10)
  a.foreach(print)
  println()

  b.foreach(println)

  val groups = x.groupBy(_ > 10)
  println(groups)

  val trues = groups(true)
  trues.foreach(println)

  println("--------------")

  val falses = groups(false)
  falses.foreach(println)

  val nums = (1 to 5).toArray

  // size = 2
  nums.sliding(2).toList  //List[Array[Int]] = List(Array(1, 2), Array(2, 3), Array(3, 4), Array(4, 5))

  // size = 2, step = 2
  nums.sliding(2,2).toList //List[Array[Int]] = List(Array(1, 2), Array(3, 4), Array(5))

  // size = 2, step = 3
  nums.sliding(2,3).toList //List[Array[Int]] = List(Array(1, 2), Array(4, 5))

  val listOfTuple2s = List((1,2), ('a', 'b'))
  val xx = listOfTuple2s.unzip //(List[AnyVal], List[AnyVal]) = (List(1, a),List(2, b))

  val couples2 = List(("Kim", "Al"), ("Julia", "Terry"))//List[(String, String)] = List((Kim,Al), (Julia,Terry))

  val (women2, men2) = couples2.unzip
  //women: List[String] = List(Kim, Julia
  //men: List[String] = List(Al, Terry)


  val women3 = List("Kim", "Julia")
  //women: List[String] = List(Kim, Julia)

  val men3 = List("Al", "Terry")
  //men: List[String] = List(Al, Terry)

  val couples = women3 zip men3
  //couples: List[(String, String)] = List((Kim,Al), (Julia,Terry))

}
