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

  //Discussion
  // three elements
  val products = Array("breadsticks", "pizza", "soft drink")

  // one element
  val prices = Array(4)

  // one resulting element
  val productsWithPrice = products.zip(prices) //Array[(String, Int)] = Array((breadsticks,4))

  val (a,b) = productsWithPrice.unzip

  println(a) //ArrayBuffer(breadsticks, pizza, soft drink)
  println(b) //ArrayBuffer(4.0, 10.0, 1.5)



}
