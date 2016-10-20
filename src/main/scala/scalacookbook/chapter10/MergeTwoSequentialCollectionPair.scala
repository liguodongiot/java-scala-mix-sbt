package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object MergeTwoSequentialCollectionPair extends App{

  val women = List("Wilma", "Betty")
  val men = List("Fred", "Barney")

  val couples = women zip men

  for ((wife, husband) <- couples) {
    println(s"$wife is married to $husband")
  }

  val couplesMap = couples.toMap //Map(Wilma -> Fred, Betty -> Barney)
  println(couplesMap)

  //Discussion
  // three elements
  val products = Array("breadsticks", "pizza", "soft drink")

  // one element
  val prices = Array(4)

  //zip函数将传进来的两个参数中相应位置上的元素组成一个pair数组。
  // 如果其中一个参数元素比较长，那么多余的参数会被删掉。
  // one resulting element
  val productsWithPrice = products.zip(prices) //Array[(String, Int)] = Array((breadsticks,4))
  println(productsWithPrice.toList)

  val (a,b) = productsWithPrice.unzip

  println(a.toList) //ArrayBuffer(breadsticks, pizza, soft drink)
  println(b.toList) //ArrayBuffer(4.0, 10.0, 1.5)

  //zipAll 函数和上面的zip函数类似，但是如果其中一个元素个数比较少，那么将用默认的元素填充。
  //zipAll
  val aaa = List("a1","a2","a3")
  val bbb = List("b1","b2","b3","b4")
  val ccc = List("c1","c2")

  val aaaWithBbb = aaa.zipAll(bbb,"##","@@")
  println(aaaWithBbb.toMap)

  val aaaWithCcc = aaa.zipAll(ccc,"%%","**")
  println(aaaWithCcc.toMap)


  //zipped
  //The zipped method on tuples generalizes several common operations to work on multiple lists.
  val values = List.range(1, 5)

  println((values, values).zipped.toMap)

  val sumOfSquares = (values, values).zipped.map(_ * _).sum
  println(sumOfSquares)


  //zipWithIndex函数将元素和其所在的下标组成一个pair。
  val series = Seq(0, 1, 1, 2, 3, 5, 8, 13)
  println(series.zipWithIndex.toMap)


}
