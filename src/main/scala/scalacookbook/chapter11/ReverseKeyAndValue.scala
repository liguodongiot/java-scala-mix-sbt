package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object ReverseKeyAndValue extends App{

  val products = Map("Breadsticks" -> "$5",
   "Pizza" -> "$10",
   "Wings" -> "$5"
  )

  //scala.collection.mutable.Map[String,String] = Map($5 -> Breadsticks, $10 -> Pizza)
  val reverseMap = for ((k,v) <- products) yield (v, k)

  //As shown, the $5 wings were lost when the values became the keys,
  // because both the breadsticks and the wings had the String value $5.

}
