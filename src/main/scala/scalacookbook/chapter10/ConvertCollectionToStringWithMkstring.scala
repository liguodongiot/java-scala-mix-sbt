package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/30.
  */
object ConvertCollectionToStringWithMkstring extends App{

  val a = Array("apple", "banana", "cherry")

  println(a.mkString)

  println(a.mkString(" "))

  println(a.mkString(", "))

  println(a.mkString("[", ", ", "]"))

  val b = Array(Array("a", "b"), Array("c", "d")) //Array(Array(a, b), Array(c, d))

  println(b.flatten.mkString(", "))

  //Discussion
  //You can also use the toString method on a collection,
  // but it returns the name of the collection with the elements
  // in the collection listed inside parentheses
  val v = Vector("apple", "banana", "cherry")

  println(v.toString)

}
