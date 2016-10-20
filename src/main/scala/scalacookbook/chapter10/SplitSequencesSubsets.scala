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

  //已第一个不满足条件的数据进行分割
  val y3 = x.span(_ < 20)
  println(y3)

  val y31 = x.span(_ > 5)
  println(y31)

  println("----------------")

  //根据索引值进行分割
  val y4 = x.splitAt(2)
  println(y4)
  val y41 = x.splitAt(4)
  println(y41)

  val (a,b) = x.partition(_ > 10)
  a.map(_+" ").foreach(print)
  println

  b.map(_+" ").foreach(print)
  println

  val groups = x.groupBy(_ > 10)
  println(groups)

  val trues = groups(true)
  trues.foreach(println)

  println("--------------")

  val falses = groups(false)
  falses.foreach(println)

  println("~~~~~~~~~~~~~~~~~~~~")

  val nums = (1 to 5).toArray

  // size = 2
  val sliding1 =  nums.sliding(2).toList  //List[Array[Int]] = List(Array(1, 2), Array(2, 3), Array(3, 4), Array(4, 5))
  val reuslt1 = sliding1.map(_.toList)
  println(reuslt1)

  // size = 2, step = 2
  val sliding2 =  nums.sliding(2,2).toList //List[Array[Int]] = List(Array(1, 2), Array(3, 4), Array(5))
  val reuslt2 = sliding2.map(_.toList)
  println(reuslt2)

  // size = 2, step = 3
  val sliding3 =  nums.sliding(2,3).toList //List[Array[Int]] = List(Array(1, 2), Array(4, 5))
  val reuslt3 = sliding3.map(_.toList)
  println(reuslt3)

  println("=====================")

  val listOfTuple2s = List((1,2), ('a', 'b'))
  val xx = listOfTuple2s.unzip //(List[AnyVal], List[AnyVal]) = (List(1, a),List(2, b))
  println(xx)


  val couples2 = List(("Kim", "Al"), ("Julia", "Terry"))//List[(String, String)] = List((Kim,Al), (Julia,Terry))

  val (women2, men2) = couples2.unzip
  //women: List[String] = List(Kim, Julia
  //men: List[String] = List(Al, Terry)
  println(women2)
  println(men2)

  println("~~~~~~~~~~~~~~~~~~~")

  val women3 = List("Kim", "Julia")
  //women: List[String] = List(Kim, Julia)

  val men3 = List("Al", "Terry")
  //men: List[String] = List(Al, Terry)

  val couples3 = women3 zip men3
  //couples: List[(String, String)] = List((Kim,Al), (Julia,Terry))
  println(couples3)
}
