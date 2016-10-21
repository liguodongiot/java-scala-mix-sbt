package scalacookbook.chapter11

/**
  * Created by liguodong on 2016/7/31.
  */
object FilterMap extends App{

  var x = scala.collection.mutable.Map(1 -> "a", 2 -> "b", 3 -> "c")

  //Mutable maps

  //using the retain method to specify which elements should be retained
  x.retain((k,v) => k > 1)
  println(x)

  x.transform((k,v) => v.toUpperCase)
  println(x)

  println("-------------")

  //Mutable and immutable maps

  val x2 = Map(1 -> "a", 2 -> "b", 3 -> "c")

  // use a predicate with the filterKeys methods
  // to define which map elements to retain.
  val y2 = x2.filterKeys(_ > 2)
  println(y2)

  def only1(i: Int) = if (i == 1) true else false

  val x3 = Map(1 -> "a", 2 -> "b", 3 -> "c")

  val y3 = x3.filterKeys(only1) //scala.collection.Map[Int,String] = Map(1 -> a)
  println(y3)

  println("~~~~~~~~~~~~~~~~")

  var m = Map(1 -> "a", 2 -> "b", 3 -> "c") //m: scala.collection.immutable.Map[Int,String] = Map(1 -> a, 2 -> b, 3 -> c)

  val newMap = m.filterKeys(Set(2,3)) //newMap: scala.collection.immutable.Map[Int,String] = Map(2 -> b, 3 -> c)
  println(newMap)

  var m2 = Map(1 -> "a", 2 -> "b", 3 -> "c")

  // access the key
  val m2New = m2.filter((t) => t._1 > 1)
  println(m2New)

  // access the value
  val m2New2 = m2.filter((t) => t._2 == "c")
  println(m2New2)

  //保留前两个
  println(m.take(2))

}
